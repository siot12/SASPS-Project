package org.example.services;

import org.example.model.Door;
import org.example.model.DoorMaterial;
import org.example.model.DoorSteel;

public class SteelDoorFactory implements DoorFactory {

    @Override
    public Door createDoor(int height, int width) {
        return new DoorSteel(height, width);
    }
}
