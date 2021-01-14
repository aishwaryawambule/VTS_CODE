package com.example.vehicleTrackingSystem.entity;


import javax.persistence.*;

/**
 * Created by aishwarya on 1/13/21.
 */

@Entity
@Table(name = "vts_location")
public class location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LOCATION_DESC")
    private String locationDesc;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAMERA_ID")
    private camera camera;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public com.example.vehicleTrackingSystem.entity.camera getCamera() {
        return camera;
    }

    public void setCamera(com.example.vehicleTrackingSystem.entity.camera camera) {
        this.camera = camera;
    }
}
