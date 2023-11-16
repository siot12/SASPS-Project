package org.example.run;

import org.example.Utils;
import org.example.controller.SmartHomeControllerWithObserver;
import org.example.model.Device;

import java.text.NumberFormat;

public class Main {
    static SmartHomeControllerWithObserver controller;
    public static void main(String[] args) {
        Utils.printMemory();

        long start = System.currentTimeMillis();

        for(int i = 0 ; i <= 10000000; i++) {
            controller = SmartHomeControllerWithObserver.getInstance();
        }
        Device light = new Device("Living Room Light");
        Device thermostat = new Device("Living Room Thermostat");

        controller.addDevice(light);
        controller.addDevice(thermostat);

        controller.turnOnAllDevices();
        controller.turnOffAllDevices();

        System.out.println(controller.getNrOfOnDevices());

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        Utils.printMemory();

    }
}