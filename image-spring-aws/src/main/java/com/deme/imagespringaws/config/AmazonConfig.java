package com.deme.imagespringaws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * sử dụng để config kết nối đến amazon
 * @author phandat-java
 *
 */

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
@Configuration
public class AmazonConfig {

	/**
	 * AWS Credenticals
	 * @return
	 */
	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new AWSCredentials() {
			
			@Override
			public String getAWSSecretKey() {
				return "UQ6IlqU1pqFMw/6jNE3AZe6S5GrBfpRQ/IGXIkcV";
			}
			
			@Override
			public String getAWSAccessKeyId() {
				return "AKIAIOEFWOGEFKTCPZPQ";
			}
		};
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}
}
