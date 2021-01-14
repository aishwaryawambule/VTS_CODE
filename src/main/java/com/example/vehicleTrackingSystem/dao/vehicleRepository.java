package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by aishwarya on 1/13/21.
 */

@Repository
public interface vehicleRepository extends JpaRepository<vehicle,Integer> {

    @Query("SELECT entity from vehicle entity where entity.id=:id")
    vehicle getVehicleById(@Param("id") Integer  id);


}
