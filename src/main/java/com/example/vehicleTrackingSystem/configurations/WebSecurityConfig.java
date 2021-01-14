package com.example.vehicleTrackingSystem.configurations;


/**
 * Created by aishwarya on 1/14/21.
 */

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.vehicleTrackingSystem.constant.Parameters;
import com.example.vehicleTrackingSystem.service.security.JWTService;


/**
 * Created by aishwarya on 1/13/21.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtTokenService;

    @Value(Parameters.KEY_JWT_AUTH_HEADER)
    String authHeader;

    @Value(Parameters.KEY_SECURITY_OPEN_API_PATTERN)
    String openApiPattern;

    @Value(Parameters.KEY_SECURITY_SECURE_API_PATTERN)
    String secureApiPattern;

    @Value(Parameters.KEY_SECURITY_CREATE_API_PATTERN)
    String userApiPattern;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(this.openApiPattern);
        web.ignoring().antMatchers(this.userApiPattern);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(this.secureApiPattern)
                .hasAnyAuthority("ADMIN")
                .and()
                .addFilterBefore(new JWTFilter(this.secureApiPattern, jwtTokenService, authHeader), UsernamePasswordAuthenticationFilter.class);

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(this.userApiPattern)
                .hasAnyAuthority(Parameters.ROLE_ADMIN)
                .and()
                .addFilterBefore(new JWTFilter(this.userApiPattern, jwtTokenService, authHeader), UsernamePasswordAuthenticationFilter.class);

    }

}

