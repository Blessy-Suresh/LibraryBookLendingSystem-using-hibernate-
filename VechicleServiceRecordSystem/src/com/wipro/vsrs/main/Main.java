package com.wipro.vsrs.main;

import java.util.ArrayList;
import com.wipro.vsrs.entity.*;
import com.wipro.vsrs.service.VehicleServiceRecordService;
import com.wipro.vsrs.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("TN10AX1234", "Praveen Kumar", "Honda City"));
        vehicles.add(new Vehicle("TN22BB9876", "Lakshmi Devi", "Hyundai Creta"));

        ArrayList<ServiceRecord> services = new ArrayList<>();

        VehicleServiceRecordService service =
                new VehicleServiceRecordService(vehicles, services);

        try {
            ArrayList<PartUsed> parts = new ArrayList<>();
            parts.add(new PartUsed("Oil Filter", 450));
            parts.add(new PartUsed("Engine Oil", 1200));

            ServiceRecord sr = new ServiceRecord(
                    "S001",
                    "TN10AX1234",
                    "2025-08-10",
                    "General service",
                    1500,
                    parts,
                    0
            );

            service.addServiceRecord(sr);

            service.updateServiceCharges("S001", 1800);

            System.out.println("Service History:");
            for (ServiceRecord r : service.getServiceHistory("TN10AX1234")) {
                System.out.println(r.getNotes());
            }

            System.out.println("\nService Summary:");
            System.out.println(service.generateServiceSummary("TN10AX1234"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
