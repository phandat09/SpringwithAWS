package com.deme.imagespringaws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * use config connect to amazon webservice
 * @author phandat-java
 *
 */

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
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
		AWSCredentials awsCredentials = new BasicAWSCredentials(
		          "AKIAIOEFWOGEFKTCPZPQ",
		          "UQ6IlqU1pqFMw/6jNE3AZe6S5GrBfpRQ/IGXIkcV"
		        );
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}
}
