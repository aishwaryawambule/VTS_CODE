package com.example.vehicleTrackingSystem.entity;


import com.example.vehicleTrackingSystem.utils.LocalDateTimeSerializerCs;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by aishwarya on 1/13/21.
 */


@SqlResultSetMappings({
        @SqlResultSetMapping(name = "vehicleMvnt", classes = {
                @ConstructorResult(targetClass = vehicleMovementReport.class, columns = {
                        @ColumnResult(name = "VEHICLE_DESC", type = String.class),
                        @ColumnResult(name = "VEHICLE_OWNER", type = String.class),
                        @ColumnResult(name = "VEHICLE_TYPE", type = String.class),
                        @ColumnResult(name = "LOCATION_DESC", type = String.class),
                        @ColumnResult(name = "CAMERA_CLASS", type = String.class),
                        @ColumnResult(name = "CAMERA_DESC", type = String.class),
                        @ColumnResult(name = "VEHICLE_MOVEMENT", type = Double.class),
                        @ColumnResult(name = "FROM_DATE", type = String.class),
                        @ColumnResult(name = "TO_DATE", type = String.class)

                })
        }),
})
@Entity
@Table(name = "vts_vehicle_movement")
public class vehicleMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    private int id;

    @Column(name = "[VEHICLE_MOVEMENT]")
    private Double vehicleMovement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID")
    private vehicle vehicle;

    @JsonSerialize(using = LocalDateTimeSerializerCs.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "FROM_DATE")
    private LocalDateTime fromDate;

    @JsonSerialize(using = LocalDateTimeSerializerCs.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "TO_DATE")
    private LocalDateTime toDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getVehicleMovement() {
        return vehicleMovement;
    }

    public void setVehicleMovement(Double vehicleMovement) {
        this.vehicleMovement = vehicleMovement;
    }

    public com.example.vehicleTrackingSystem.entity.vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(com.example.vehicleTrackingSystem.entity.vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }
}
