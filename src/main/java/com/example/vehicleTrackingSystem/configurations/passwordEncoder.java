package com.example.vehicleTrackingSystem.configurations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by aishwarya on 1/13/21.
 */

/**
 * to generate BCrypt password !!!
*/

public class passwordEncoder {

    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.print(encodedPassword);
    }
}
