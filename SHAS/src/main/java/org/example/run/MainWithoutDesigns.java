package org.example.run;

import org.example.Utils;
import org.example.controller.SmartHomeControllerWithoutObserver;
import org.example.model.DeviceWithoutObserver;

public class MainWithoutDesigns {

    static SmartHomeControllerWithoutObserver controllerWithoutObserver;

    public static void main(String[] args) {
        Utils.printMemory();
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 10000000; i++) {
            controllerWithoutObserver = new SmartHomeControllerWithoutObserver();
        }
        DeviceWithoutObserver light = new DeviceWithoutObserver("Living Room Light");
        DeviceWithoutObserver thermostat = new DeviceWithoutObserver("Living Room Thermostat");
        controllerWithoutObserver.addDevice(light);
        controllerWithoutObserver.addDevice(thermostat);
        controllerWithoutObserver.turnOnAllDevices();
        controllerWithoutObserver.turnOffAllDevices();

        System.out.println(controllerWithoutObserver.getNrOfOnDevices());

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        Utils.printMemory();

    }
}
