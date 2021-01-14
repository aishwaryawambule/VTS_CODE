package com.example.vehicleTrackingSystem.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by aishwarya on 1/13/21.
 */

@Entity
@Table(name="vts_user")
public class user  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private Integer id;



    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_ADDRESS")
    private String userAddress;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "IS_ADMIN")
    private Boolean isAdmin;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name = "vts_user_Roles",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns  = @JoinColumn(name = "ROLE_ID")
    )
    private Set<roles> rolesSet = new HashSet<>();

    public user(Integer id, String userName, String userPassword, String userAddress, Date createdDate, Date updatedDate, Boolean isAdmin, Set<roles> rolesSet) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isAdmin = isAdmin;
        this.rolesSet = rolesSet;
    }

    public user(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }


    public Set<roles> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<roles> rolesSet) {
        this.rolesSet = rolesSet;
    }
}
