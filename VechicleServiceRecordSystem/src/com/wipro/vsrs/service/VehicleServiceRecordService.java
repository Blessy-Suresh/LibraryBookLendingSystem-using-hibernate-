package com.wipro.vsrs.service;

import java.util.ArrayList;
import com.wipro.vsrs.entity.*;
import com.wipro.vsrs.util.*;

public class VehicleServiceRecordService {

    ArrayList<Vehicle> vehicles;
    ArrayList<ServiceRecord> services;

    public VehicleServiceRecordService(ArrayList<Vehicle> vehicles,
                                       ArrayList<ServiceRecord> services) {
        this.vehicles = vehicles;
        this.services = services;
    }

    public Vehicle findVehicle(String vehicleId) throws VehicleNotFoundException {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(vehicleId)) {
                return v;
            }
        }
        throw new VehicleNotFoundException();
    }

    public void addServiceRecord(ServiceRecord sr)
            throws VehicleNotFoundException, InvalidServiceOperationException {

        findVehicle(sr.getVehicleId());

        if (sr.getNotes() == null || sr.getNotes().trim().isEmpty()) {
            throw new InvalidServiceOperationException();
        }

        if (sr.getLaborCharges() < 0) {
            throw new InvalidServiceOperationException();
        }

        double total = sr.getLaborCharges();

        for (PartUsed p : sr.getPartsUsed()) {
            if (p.getCost() < 0) {
                throw new InvalidServiceOperationException();
            }
            total = total + p.getCost();
        }

        sr.setTotalCost(total);
        services.add(sr);
    }

    public ServiceRecord findService(String serviceId)
            throws ServiceNotFoundException {

        for (ServiceRecord sr : services) {
            if (sr.getServiceId().equals(serviceId)) {
                return sr;
            }
        }
        throw new ServiceNotFoundException();
    }

    public void updateServiceCharges(String serviceId, double newLaborCharges)
            throws ServiceNotFoundException, InvalidServiceOperationException {

        if (newLaborCharges < 0) {
            throw new InvalidServiceOperationException();
        }

        ServiceRecord sr = findService(serviceId);
        sr.setLaborCharges(newLaborCharges);

        double total = newLaborCharges;
        for (PartUsed p : sr.getPartsUsed()) {
            total = total + p.getCost();
        }

        sr.setTotalCost(total);
    }

    public ArrayList<ServiceRecord> getServiceHistory(String vehicleId)
            throws VehicleNotFoundException {

        findVehicle(vehicleId);

        ArrayList<ServiceRecord> list = new ArrayList<>();
        for (ServiceRecord sr : services) {
            if (sr.getVehicleId().equals(vehicleId)) {
                list.add(sr);
            }
        }
        return list;
    }

    public String generateServiceSummary(String vehicleId)
            throws VehicleNotFoundException {

        Vehicle v = findVehicle(vehicleId);
        int count = 0;
        double amount = 0;
        String date = "";

        for (ServiceRecord sr : services) {
            if (sr.getVehicleId().equals(vehicleId)) {
                count++;
                amount = amount + sr.getTotalCost();
                date = sr.getServiceDate();
            }
        }

        return "Owner Name: " + v.getOwnerName()
                + "\nVehicle Model: " + v.getModel()
                + "\nTotal Services: " + count
                + "\nLast Service Date: " + date
                + "\nTotal Amount Spent: " + amount;
    }
}
