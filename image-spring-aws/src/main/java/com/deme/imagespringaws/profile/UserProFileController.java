package com.deme.imagespringaws.profile;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

@RestController
@RequestMapping("/api/v1/user-profile")
@CrossOrigin("*")
public class UserProFileController {

	private final UserProfileService profileService;

	@Autowired
	public UserProFileController(UserProfileService profileService) {
		super();
		this.profileService = profileService;
	}
	@GetMapping
	public List<UserProfile> getUserProfiles(){
		return profileService.getUserProfiles();
	}
	
	@PostMapping(
		path = "{userProfileID}/images/upload",
		consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public void uploadUserProfileIamges(@PathVariable("userProfileID") UUID userProfileId,
			@RequestParam MultipartFile file) {
		profileService.uploadUserProfileImages(userProfileId,file);
	}
	 @GetMapping("{userProfileId}/images/download")
	    public byte[] downloadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId) {
	        return profileService.downloadUserProfileImage(userProfileId);
	    }
}
