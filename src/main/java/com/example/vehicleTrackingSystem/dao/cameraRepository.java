package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by aishwarya on 1/14/21.
 */

@Repository
public interface cameraRepository extends JpaRepository<camera,Integer> {

    @Query("SELECT entity from camera entity where entity.id=:id")
    camera getCameraById(@Param("id") Integer  id);


}

