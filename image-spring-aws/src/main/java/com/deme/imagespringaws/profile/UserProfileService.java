package com.deme.imagespringaws.profile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deme.imagespringaws.bukect.Bucket;
import com.deme.imagespringaws.fileStore.FileStore;

@Service
public class UserProfileService {

	private final UserProfileDataAccessService userProfileDataAccessService;
	private final FileStore fileStore;
	
	public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
		super();
		this.userProfileDataAccessService = userProfileDataAccessService;
		this.fileStore = fileStore;
	}
	List<UserProfile> getUserProfiles(){
		return userProfileDataAccessService.getUserProFiles();
	}
	/**
	 * 1.check file images is not  emtry
	 * 2.if file is an images
	 * 3.the user exist in our database
	 * 4.grab some metadata from file if any
	 * 5.store the iamges in s3 and update database with s3 images link
	 * @param userProfileId
	 * @param fileImages
	 */
	public void uploadUserProfileImages(UUID userProfileId, MultipartFile file) {
		
		// 1
		if(file.isEmpty()) {
			throw new IllegalStateException("Can not upload file [" + file.getSize() +"]");
		}
		//2
		if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),ContentType.IMAGE_PNG.getMimeType(),ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
			throw new IllegalStateException("File can not image");
		}
		//3
		UserProfile user = userProfileDataAccessService
			.getUserProFiles()
			.stream()
			.filter(userprofile -> userprofile.getUserProfileID().equals(userProfileId))
			.findFirst()
			.orElseThrow(() ->  new IllegalStateException(String.format("UserProfile can %s not found ", userProfileId)));
		//4
		Map<String, String > metadata = new HashMap<String, String>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		
		String path = String .format("%s/%s", Bucket.PROFILE_IMAGE.getBucketName(),userProfileId);
		String fileName = String.format("%s-%s", file.getOriginalFilename(),UUID.randomUUID());
		
		//5
		try {
			fileStore.save(path, fileName, Optional.ofNullable(metadata), file.getInputStream());
			user.setUserProfileImagesLink(fileName);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	 byte[] downloadUserProfileImage(UUID userProfileId) {
		 UserProfile user = userProfileDataAccessService
					.getUserProFiles()
					.stream()
					.filter(userprofile -> userprofile.getUserProfileID().equals(userProfileId))
					.findFirst()
					.orElseThrow(() ->  new IllegalStateException(String.format("UserProfile can %s not found ", userProfileId)));

	        String path = String.format("%s/%s",
	                Bucket.PROFILE_IMAGE.getBucketName(),
	                user.getUserProfileID());

	        return user.getUserProfileImagesLink().map(key -> fileStore.download(path, key)).orElse(new byte[0]);

	    }
}
