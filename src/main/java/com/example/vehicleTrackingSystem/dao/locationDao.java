package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.location;
import com.example.vehicleTrackingSystem.entity.locationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aishwarya on 1/14/2021
 *
 */

@Service
public class locationDao {

    @Autowired
    locationRepository locationRepository;

    @Autowired
    cameraRepository cameraRepository;

    public void addLocation(locationDto locations) {

        location location1 = new location();
        location1.setLocationDesc(locations.getLocationDesc());
        location1.setCamera(cameraRepository.getCameraById(locations.getCameraId()));
        locationRepository.save(location1);

    }


}
