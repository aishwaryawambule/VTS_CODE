package com.example.vehicleTrackingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vehicleTrackingSystem.entity.user;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by aishwarya on 1/13/21.
 */

@Repository
public interface userRepository extends JpaRepository<user,Integer> {

    @Query("SELECT entity from user entity")
    List<user> getAllUsers();

    @Query("SELECT entity from user entity where entity.id=:id")
    user getUserByID(@Param("id") Integer  id);

    @Query("SELECT entity from user entity where entity.userName=:userName")
    user getUserByUserName(@Param("userName") String  userName);


}