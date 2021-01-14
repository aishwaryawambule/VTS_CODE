package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by aishwarya on 1/14/21.
 */

@Repository
public interface locationRepository extends JpaRepository<location,Integer> {

    @Query("SELECT entity from location entity where entity.id=:id")
    location getlocationById(@Param("id") Integer  id);


}

