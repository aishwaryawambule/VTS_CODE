package com.example.vehicleTrackingSystem.Controller;

import com.example.vehicleTrackingSystem.entity.camera;
import com.example.vehicleTrackingSystem.service.modelService.cameraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aishwarya on 1/14/21.
 */


@RestController
@RequestMapping("/api")
public class cameraRest {

       private static final Logger LOGGER = LoggerFactory.getLogger(camera.class);

        @Autowired
        public cameraService cameraService;

        @PostMapping("secure/addCamera")
        public ResponseEntity addCamera(@RequestBody camera camera){
            try {
                cameraService.addCamera(camera);
                return ResponseEntity.status(200).body("inserted successfully");

            } catch (Exception e) {
                LOGGER.error(":::::::::::::::::::::::  Unable to insert camera data ::::::::::::::::::::: " + e.toString());
                return ResponseEntity.status(500).body(e.toString());
            }
        }

    }



