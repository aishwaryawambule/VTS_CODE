package com.example.vehicleTrackingSystem.service.modelService;

import com.example.vehicleTrackingSystem.dao.locationDao;
import com.example.vehicleTrackingSystem.entity.location;
import com.example.vehicleTrackingSystem.entity.locationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aishwarya on 1/14/21.
 */


@Service
public class locationService {


    @Autowired
    locationDao locationDao;

    public void addLocation(locationDto location) {
        locationDao.addLocation(location);
    }

}
