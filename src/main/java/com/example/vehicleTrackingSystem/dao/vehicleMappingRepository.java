package com.example.vehicleTrackingSystem.dao;

import com.example.vehicleTrackingSystem.entity.vehicleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aishwarya on 1/13/21.
 */

@Repository
public interface vehicleMappingRepository extends JpaRepository<vehicleMapping,Integer> {

}