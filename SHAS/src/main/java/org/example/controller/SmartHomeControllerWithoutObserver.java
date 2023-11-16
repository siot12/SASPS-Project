package org.example.controller;

import org.example.model.Device;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeControllerWithoutObserver implements SmartHomeController{
    private List<Device> devices;
    public int nrOfOnDevices;

    public SmartHomeControllerWithoutObserver() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public void turnOnAllDevices() {
        for (Device device : devices) {
            device.turnOn();
            nrOfOnDevices++;
        }
    }

    public void turnOffAllDevices() {
        for (Device device : devices) {
            device.turnOff();
            nrOfOnDevices--;
        }
    }

    @Override
    public int getNrOfOnDevices() {
        return nrOfOnDevices;
    }
}
