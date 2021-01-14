package com.example.vehicleTrackingSystem.entity;

/**
 * Created by aishwarya on 1/13/21.
 */

public class locationDto {

    private String locationDesc;
    private Integer cameraId;

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }
}
