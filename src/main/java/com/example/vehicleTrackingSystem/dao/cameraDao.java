package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by aishwarya on 1/14/21.
 */

@Service
public class cameraDao {

    @Autowired
    cameraRepository cameraRepository;

    public void addCamera(camera camera) {
        cameraRepository.save(camera);
    }


}
