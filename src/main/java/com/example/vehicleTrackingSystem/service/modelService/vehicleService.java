package com.example.vehicleTrackingSystem.service.modelService;

import com.example.vehicleTrackingSystem.dao.vehicleDao;
import com.example.vehicleTrackingSystem.dao.vehicleMovementDao;
import com.example.vehicleTrackingSystem.entity.vehicle;
import com.example.vehicleTrackingSystem.entity.vehicleMovementReport;
import com.example.vehicleTrackingSystem.entity.vehicleDto;
import com.example.vehicleTrackingSystem.entity.vehicleMvntDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by aishwarya on 1/13/21.
 */

@Service
public class vehicleService {

    @Autowired
    vehicleDao vehicleDao;

    @Autowired
    vehicleMovementDao vehicleMovementDao;

    public void addVehicle(vehicle vehicle) {
        vehicleDao.addVehicle(vehicle);
    }
    public void addVehicleMapping(vehicleDto vehicleDto) {
        vehicleDao.addVehicleMapping(vehicleDto);
    }
    public void addVehicleMovement(vehicleMvntDto vehicleMvntDto) {
        vehicleMovementDao.addVehicleMovement(vehicleMvntDto);
    }
    public List<vehicleMovementReport> getVehicleMovement(Integer locationId, Integer cameraId) {
        return vehicleMovementDao.getVehicleMovement(locationId,cameraId);
    }


}
