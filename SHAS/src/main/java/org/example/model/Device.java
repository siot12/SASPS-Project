package org.example.model;

import org.example.observer.DeviceObserver;
import org.example.observer.DeviceSubject;

import java.util.ArrayList;
import java.util.List;

// Concrete Observer (Device)
public class Device implements DeviceSubject {
    private String name;
    private boolean isOn;
    private List<DeviceObserver> observers;

    public Device(String name) {
        this.name = name;
        this.isOn = false;
        this.observers = new ArrayList<>();
    }

    public void turnOn() {
        isOn = true;
        notifyObservers();
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        notifyObservers();
        System.out.println(name + " is now OFF.");
    }

    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (DeviceObserver observer : observers) {
            observer.update(this);
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }
}