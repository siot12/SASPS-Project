package org.example.controller;

import org.example.model.Device;
import org.example.model.DeviceWithoutObserver;
import org.example.model.Room;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeControllerWithoutObserver implements SmartHomeController {
    private List<DeviceWithoutObserver> devices;
    public int nrOfOnDevices;

    private List<Room> rooms;

    public SmartHomeControllerWithoutObserver() {
        devices = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public void addDevice(DeviceWithoutObserver device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public void turnOnAllDevices() {
        for (DeviceWithoutObserver device : devices) {
            device.turnOn();
            nrOfOnDevices++;
        }
    }

    public void turnOffAllDevices() {
        for (DeviceWithoutObserver device : devices) {
            device.turnOff();
            nrOfOnDevices--;
        }
    }

    @Override
    public int getNrOfOnDevices() {
        return nrOfOnDevices;
    }

    @Override
    public void addRoom(Room room) {

    }


}
