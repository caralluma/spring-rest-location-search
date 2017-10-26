package com.egnyte.locationsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;

@Configuration
public class Facebook4JConfig {
	
	@Bean
	public Facebook facebook4JConfiguration() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthAppId("151164385497654").setOAuthAppSecret("7819787c99bf93271cea72eda7070ffa");
		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();
		try {
			facebook.setOAuthAccessToken(facebook.getOAuthAppAccessToken());
		} catch (FacebookException e) {
			e.printStackTrace();
		}
		return facebook;
	}
}
