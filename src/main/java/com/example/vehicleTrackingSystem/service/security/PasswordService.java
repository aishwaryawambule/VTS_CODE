package com.example.vehicleTrackingSystem.service.security;

import com.example.vehicleTrackingSystem.constant.Parameters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by aishwarya on 1/13/21.
 */

/**
 * Password Service checking whether password entered matches or not for token generation !!
 * */

@Configuration
@Service
public class PasswordService {

    @Value(Parameters.KEY_JWT_SECRET)
    private String secret;
	
    private BCryptPasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

	public String encode(String rawPassword) {
		return this.passwordEncoder.encode(rawPassword);
	}

	public boolean equals(String rawPassword, String encodedPassword) {
		return this.passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
