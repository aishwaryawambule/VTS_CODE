package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.vehicleDto;
import com.example.vehicleTrackingSystem.entity.vehicleMapping;
import com.example.vehicleTrackingSystem.entity.vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aishwarya on 1/13/21.
 */

@Service
public class vehicleDao {

    @Autowired
    vehicleRepository vehicleRepository;

    @Autowired
    locationRepository locationRepository;

    @Autowired
    vehicleMappingRepository vehicleMappingRepository;

    public void addVehicle(vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
    public void addVehicleMapping(vehicleDto vehicleDto) {

        vehicleMapping vehicle = new vehicleMapping();
        vehicle.setVehicle(vehicleRepository.getVehicleById(vehicleDto.getVehicleId()));
        vehicle.setLocation(locationRepository.getlocationById(vehicleDto.getLocationId()));
        vehicleMappingRepository.save(vehicle);
    }



}
