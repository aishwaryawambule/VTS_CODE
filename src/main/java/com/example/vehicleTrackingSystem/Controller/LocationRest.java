package com.example.vehicleTrackingSystem.Controller;

import com.example.vehicleTrackingSystem.entity.location;
import com.example.vehicleTrackingSystem.entity.locationDto;
import com.example.vehicleTrackingSystem.service.modelService.locationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aishwarya on 1/13/21.
 */
@RestController
@RequestMapping("/api")
public class LocationRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(location.class);

    @Autowired
    locationService locationService;

    @PostMapping("secure/addLocation")
    public ResponseEntity addLocation(@RequestBody locationDto location){
        try {
            locationService.addLocation(location);
            return ResponseEntity.status(200).body("inserted successfully");

        } catch (Exception e) {
            LOGGER.error(":::::::::::::::::::::::  Unable to insert location data ::::::::::::::::::::: " + e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }

}
