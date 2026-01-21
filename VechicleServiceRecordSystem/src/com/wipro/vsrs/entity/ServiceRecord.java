package com.wipro.vsrs.entity;

import java.util.ArrayList;

public class ServiceRecord {

    private String serviceId;
    private String vehicleId;
    private String serviceDate;
    private String notes;
    private double laborCharges;
    private ArrayList<PartUsed> partsUsed;
    private double totalCost;

    public ServiceRecord() {
    }

    public ServiceRecord(String serviceId, String vehicleId, String serviceDate,
                         String notes, double laborCharges,
                         ArrayList<PartUsed> partsUsed, double totalCost) {
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.notes = notes;
        this.laborCharges = laborCharges;
        this.partsUsed = partsUsed;
        this.totalCost = totalCost;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getLaborCharges() {
        return laborCharges;
    }

    public void setLaborCharges(double laborCharges) {
        this.laborCharges = laborCharges;
    }

    public ArrayList<PartUsed> getPartsUsed() {
        return partsUsed;
    }

    public void setPartsUsed(ArrayList<PartUsed> partsUsed) {
        this.partsUsed = partsUsed;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
