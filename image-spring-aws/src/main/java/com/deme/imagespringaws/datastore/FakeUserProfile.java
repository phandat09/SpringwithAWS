package com.deme.imagespringaws.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deme.imagespringaws.profile.UserProfile;


public class FakeUserProfile {

	private static final List<UserProfile> USER_PROFILES = new ArrayList<UserProfile>();
	
	static {
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(),"PhanDat-09",null));
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "SmitLane", null));
	}

	public   List<UserProfile> getUserProfiles() {
		return USER_PROFILES;
	}
	
}
