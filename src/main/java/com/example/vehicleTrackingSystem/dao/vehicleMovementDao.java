package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.vehicleMovement;
import com.example.vehicleTrackingSystem.entity.vehicleMvntDto;
import com.example.vehicleTrackingSystem.entity.vehicleMovementReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by aishwarya on 1/13/21.
 */

@Service
public class vehicleMovementDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    vehicleMovementRepo vehicleMovementRepo;

    @Autowired
    vehicleRepository vehicleRepository;

    public void addVehicleMovement(vehicleMvntDto vehicleMvntDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        vehicleMovement vehicleMovement1 = new vehicleMovement();
        vehicleMovement1.setVehicle(vehicleRepository.getVehicleById(vehicleMvntDto.getVehicleId()));
        vehicleMovement1.setVehicleMovement(vehicleMvntDto.getVehicleMovement());
        vehicleMovement1.setFromDate(LocalDateTime.parse(vehicleMvntDto.getFromDate(),formatter) );
        vehicleMovement1.setToDate(LocalDateTime.parse(vehicleMvntDto.getToDate(),formatter) );
        vehicleMovementRepo.save(vehicleMovement1);
    }

    public List<vehicleMovementReport> getVehicleMovement(Integer locationId, Integer cameraId) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("vts_vehicleMovement", "vehicleMvnt");
        storedProcedureQuery.registerStoredProcedureParameter("locationId",Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("cameraId",Integer.class, ParameterMode.IN);

        storedProcedureQuery.setParameter("locationId",locationId);
        storedProcedureQuery.setParameter("cameraId",cameraId);
        return storedProcedureQuery.getResultList();

    }

}
