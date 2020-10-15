package com.deme.imagespringaws.bukect;

public enum Bucket {

	PROFILE_IMAGE("phandat-upload-images-v1");
	private final String bucketName;

	Bucket(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}
}
