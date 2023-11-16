package org.example.observer;


// Subject interface
public interface DeviceSubject {
    void addObserver(DeviceObserver observer);
    void removeObserver(DeviceObserver observer);
    void notifyObservers();
}
