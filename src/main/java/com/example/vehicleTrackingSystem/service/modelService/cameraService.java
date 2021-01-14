package com.example.vehicleTrackingSystem.service.modelService;

import com.example.vehicleTrackingSystem.dao.cameraDao;
import com.example.vehicleTrackingSystem.entity.camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aishwarya on 1/14/21.
 */

@Service
public class cameraService {


    @Autowired
    cameraDao cameraDao;

    public void addCamera(camera camera) {
        cameraDao.addCamera(camera);
    }

}
