package com.example.vehicleTrackingSystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.vehicleTrackingSystem.entity.user;
import com.example.vehicleTrackingSystem.service.modelService.userService;

import java.util.List;

/**
 * Created by aishwarya on 1/13/21.
 */

@RestController
@RequestMapping("/api")
public class userRest {

    @Autowired
    public userService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(user.class);

    @GetMapping("secure/allUser")
    public ResponseEntity getAllUsers(){
        try{
            List<user> usersList = userService.getAllUsers();
            return  ResponseEntity.status(200).body(usersList);
        }
        catch (Exception e){
            LOGGER.error("Unable to fetch users data: "+ e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }

}
