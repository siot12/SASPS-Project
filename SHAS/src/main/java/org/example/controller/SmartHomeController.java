package org.example.controller;

import org.example.model.Room;

public interface SmartHomeController {

    int getNrOfOnDevices();

    void addRoom(Room room);
}
