package com.deme.imagespringaws.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deme.imagespringaws.datastore.FakeUserProfile;

@Repository
public class UserProfileDataAccessService {

	private final FakeUserProfile fakeUserProfile;
	@Autowired
	public UserProfileDataAccessService(FakeUserProfile fakeUserProfile) {
		super();
		this.fakeUserProfile = fakeUserProfile;
	}
	List<UserProfile> getUserProFiles(){
		return fakeUserProfile.getUserProfiles();
	}
	
}
