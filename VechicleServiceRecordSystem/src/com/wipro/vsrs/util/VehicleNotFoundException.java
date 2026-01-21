package com.wipro.vsrs.util;

public class VehicleNotFoundException extends Exception {
    @Override
    public String toString() {
        return "Vehicle not found";
    }
}
