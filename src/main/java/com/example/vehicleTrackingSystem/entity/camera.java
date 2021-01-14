package com.example.vehicleTrackingSystem.entity;

import javax.persistence.*;


/**
 * Created by aishwarya on 1/14/21.
 */

@Entity
@Table(name="vts_camera")
public class camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CAMERA_CLASS")
    private String cameraClass;

    @Column(name = "CAMERA_DESC")
    private String cameraDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
