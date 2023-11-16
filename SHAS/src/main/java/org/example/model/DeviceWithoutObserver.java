package org.example.model;


class DeviceWithoutObserver {
    private String name;
    private boolean isOn;

    public DeviceWithoutObserver(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }
}
