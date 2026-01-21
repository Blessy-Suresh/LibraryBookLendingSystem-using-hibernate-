package com.wipro.vsrs.entity;

public class Vehicle {

    private String vehicleId;
    private String ownerName;
    private String model;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String ownerName, String model) {
        this.vehicleId = vehicleId;
        this.ownerName = ownerName;
        this.model = model;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
