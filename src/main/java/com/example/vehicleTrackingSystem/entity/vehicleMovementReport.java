package com.example.vehicleTrackingSystem.entity;

/**
 * Created by aishwarya on 1/13/21.
 */

public class vehicleMovementReport {

    private String vehicleDesc;
    private String vehicleOwner;
    private String vehicleType;
    private String locationDesc;
    private String cameraClass;
    private String cameraDesc;
    private Double vehicleMovement;
    private String fromDate;
    private String toDate;

    public  vehicleMovementReport(){

    }

    public vehicleMovementReport(String vehicleDesc, String vehicleOwner, String vehicleType, String locationDesc, String cameraClass, String cameraDesc, Double vehicleMovement, String fromDate, String toDate) {
        this.vehicleDesc = vehicleDesc;
        this.vehicleOwner = vehicleOwner;
        this.vehicleType = vehicleType;
        this.locationDesc = locationDesc;
        this.cameraClass = cameraClass;
        this.cameraDesc = cameraDesc;
        this.vehicleMovement = vehicleMovement;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getCameraClass() {
        return cameraClass;
    }

    public void setCameraClass(String cameraClass) {
        this.cameraClass = cameraClass;
    }

    public String getCameraDesc() {
        return cameraDesc;
    }

    public void setCameraDesc(String cameraDesc) {
        this.cameraDesc = cameraDesc;
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
