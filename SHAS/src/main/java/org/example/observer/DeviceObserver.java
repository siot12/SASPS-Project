package org.example.observer;


import org.example.model.Device;

// Observer interface
public interface DeviceObserver {
    void update(Device device);
}

