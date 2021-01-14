package com.example.vehicleTrackingSystem.bean;


/**
 * Created by aishwarya on 1/13/21.
 */
/**
 * This class receives the username and password from the request.
 *
 */

public class AuthenticationBean {

    private String username;
    private String password;
    private int id;

    public AuthenticationBean(){}

    public AuthenticationBean(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
