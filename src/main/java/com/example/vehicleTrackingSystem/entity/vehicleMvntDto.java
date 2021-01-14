package com.example.vehicleTrackingSystem.entity;

/**
 * Created by aishwarya on 1/13/21.
 */

public class vehicleMvntDto {

    private Integer vehicleId;
    private Double vehicleMovement;
    private String fromDate;
    private String toDate;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getVehicleMovement() {
        return vehicleMovement;
    }

    public void setVehicleMovement(Double vehicleMovement) {
        this.vehicleMovement = vehicleMovement;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
