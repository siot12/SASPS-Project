package org.example.services;

import org.example.model.Door;

public interface DoorFactory {
    Door createDoor(int height, int width);
}
