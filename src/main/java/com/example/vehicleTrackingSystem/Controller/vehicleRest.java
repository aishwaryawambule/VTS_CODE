package com.example.vehicleTrackingSystem.Controller;


import com.example.vehicleTrackingSystem.entity.vehicle;
import com.example.vehicleTrackingSystem.entity.vehicleDto;
import com.example.vehicleTrackingSystem.entity.vehicleMvntDto;
import com.example.vehicleTrackingSystem.entity.vehicleMovementReport;
import com.example.vehicleTrackingSystem.service.modelService.vehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by aishwarya on 1/13/21.
 */

@RestController
@RequestMapping("/api")
public class vehicleRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(vehicle.class);

    @Autowired
    vehicleService vehicleService;

    @PostMapping("secure/addVehicle")
    public ResponseEntity addLocation(@RequestBody vehicle vehicle){
        try {
            vehicleService.addVehicle(vehicle);
            return ResponseEntity.status(200).body("inserted successfully");

        } catch (Exception e) {
            LOGGER.error(":::::::::::::::::::::::  Unable to insert vehicle data ::::::::::::::::::::: " + e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }

    @PostMapping("secure/addVehicleMapping")
    public ResponseEntity addVehicleMapping(@RequestBody vehicleDto vehicleDto){
        try {
            vehicleService.addVehicleMapping(vehicleDto);
            return ResponseEntity.status(200).body("mapped successfully");

        } catch (Exception e) {
            LOGGER.error(":::::::::::::::::::::::  Unable to map vehicle data ::::::::::::::::::::: " + e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }

    @PostMapping("secure/addVehicleMovement")
    public ResponseEntity addVehicleMovement(@RequestBody vehicleMvntDto vehicleMvntDto){
        try {
            vehicleService.addVehicleMovement(vehicleMvntDto);
            return ResponseEntity.status(200).body("vehicle movement added successfully");

        } catch (Exception e) {
            LOGGER.error(":::::::::::::::::::::::  Unable to add vehicle movement data ::::::::::::::::::::: " + e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }

    @GetMapping("secure/getVehicleMovement")
    public ResponseEntity getVehicleMovement(@RequestParam Integer locationId, @RequestParam Integer cameraId){
        try {

            List<vehicleMovementReport>  vehicleMovementReports= vehicleService.getVehicleMovement(locationId,cameraId);
            return ResponseEntity.status(200).body(vehicleMovementReports);

        } catch (Exception e) {
            LOGGER.error(":::::::::::::::::::::::  Unable to generate vehicle movement report ::::::::::::::::::::: " + e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }




}
