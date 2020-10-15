package com.deme.imagespringaws.profile;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-profile")
public class UserProFileController {

	private final UserProfileService profileService;

	public UserProFileController(UserProfileService profileService) {
		super();
		this.profileService = profileService;
	}
	@GetMapping
	public List<UserProfile> getUserProfiles(){
		return profileService.getUserProfiles();
	}
	
}
