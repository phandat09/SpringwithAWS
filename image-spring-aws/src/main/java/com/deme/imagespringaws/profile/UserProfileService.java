package com.deme.imagespringaws.profile;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

	private final UserProfileDataAccessService userProfileDataAccessService;

	public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
		super();
		this.userProfileDataAccessService = userProfileDataAccessService;
	}
	
	List<UserProfile> getUserProfiles(){
		return userProfileDataAccessService.getUserProFiles();
	}
}
