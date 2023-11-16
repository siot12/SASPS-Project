package org.example.controller;

import org.example.observer.DeviceObserver;
import org.example.model.Device;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject (SmartHomeController)
public class SmartHomeControllerWithObserver implements DeviceObserver,SmartHomeController {
    private List<Device> devices;
    private static SmartHomeControllerWithObserver instance;

    private int nrOfOnDevices;
    private SmartHomeControllerWithObserver() {
        devices = new ArrayList<>();
    }
    public static synchronized SmartHomeControllerWithObserver getInstance() {
        if (instance == null) {
            instance = new SmartHomeControllerWithObserver();
        }
        return instance;
    }
    public void addDevice(Device device) {
        devices.add(device);
        device.addObserver(this);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
        device.removeObserver(this);
    }

    public void turnOnAllDevices() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    public void turnOffAllDevices() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

    @Override
    public void update(Device device) {
        // Handle device updates if needed
        System.out.println("SmartHomeController received an update from " + device.getName());
        if(device.isOn()){
            nrOfOnDevices++;
        }
        else{
            nrOfOnDevices--;
        }
    }

    @Override
    public int getNrOfOnDevices() {
        return nrOfOnDevices;
    }
}