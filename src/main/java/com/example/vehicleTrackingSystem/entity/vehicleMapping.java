package com.example.vehicleTrackingSystem.entity;

import javax.persistence.*;

/**
 * Created by aishwarya on 1/13/21.
 */

@Entity
@Table(name = "vts_vehicle_mapping")
public class vehicleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private location location;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID")
    private vehicle vehicle;

    public location getLocation() {
        return location;
    }

    public void setLocation(location location) {
        this.location = location;
    }

    public vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
