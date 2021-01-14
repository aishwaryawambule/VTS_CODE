package com.example.vehicleTrackingSystem.constant;
/**
 * Created by aishwarya on 1/13/21.
 */

/**
 * This class contains parameters used by the whole application.
 *
 */
public class Parameters {

	public final static String ROLE_ADMIN = "ADMIN";
	public final static String ROLE_USER = "USER";

	public final static String KEY_JWT_AUTH_HEADER = "${jwt.auth.header}";
	public final static String KEY_JWT_EXPIRE_HOURS = "${jwt.expire.hours}";
	public final static String KEY_JWT_SECRET = "${jwt.secret}";

	public final static String KEY_SECURITY_OPEN_API_PATTERN = "${api.pattern.open}";
	public final static String KEY_SECURITY_SECURE_API_PATTERN = "${api.pattern.secure}";
	public final static String KEY_SECURITY_CREATE_API_PATTERN = "${api.pattern.user}";


}
