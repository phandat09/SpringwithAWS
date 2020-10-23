package com.deme.imagespringaws.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.deme.imagespringaws.profile.UserProfile;

@Repository
public class FakeUserProfile {

	private static final List<UserProfile> USER_PROFILES = new ArrayList<UserProfile>();
	
	static {
		USER_PROFILES.add(new UserProfile(UUID.fromString("b804d54a-477d-4283-85c7-19ef139383d9"),"PhanDat-09",null));
		USER_PROFILES.add(new UserProfile(UUID.fromString("ef060121-cb4c-4436-a3cd-7aed9b4f7489"), "SmitLane", null));
	}

	public   List<UserProfile> getUserProfiles() {
		return USER_PROFILES;
	}
	
}
