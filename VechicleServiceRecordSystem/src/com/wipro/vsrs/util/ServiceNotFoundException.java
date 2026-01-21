package com.wipro.vsrs.util;

public class ServiceNotFoundException extends Exception {
    @Override
    public String toString() {
        return "Service record not found";
    }
}
