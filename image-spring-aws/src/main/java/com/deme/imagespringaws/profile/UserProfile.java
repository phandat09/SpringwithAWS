package com.deme.imagespringaws.profile;

import java.util.Optional;
import java.util.UUID;

public class UserProfile {

	private UUID userProfileID;
	private String userName;
	private String userProfileImagesLink; // S3 key
	public UUID getUserProfileID() {
		return userProfileID;
	}
	public void setUserProfileID(UUID userProfileID) {
		this.userProfileID = userProfileID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Optional<String> getUserProfileImagesLink() {
		return Optional.ofNullable(userProfileImagesLink) ;
	}
	public void setUserProfileImagesLink(String userProfileImagesLink) {
		this.userProfileImagesLink = userProfileImagesLink;
	}
	public UserProfile(UUID userProfileID, String userName, String userProfileImagesLink) {
		super();
		this.userProfileID = userProfileID;
		this.userName = userName;
		this.userProfileImagesLink = userProfileImagesLink;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userProfileID == null) ? 0 : userProfileID.hashCode());
		result = prime * result + ((userProfileImagesLink == null) ? 0 : userProfileImagesLink.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userProfileID == null) {
			if (other.userProfileID != null)
				return false;
		} else if (!userProfileID.equals(other.userProfileID))
			return false;
		if (userProfileImagesLink == null) {
			if (other.userProfileImagesLink != null)
				return false;
		} else if (!userProfileImagesLink.equals(other.userProfileImagesLink))
			return false;
		return true;
	}
	
	
}
