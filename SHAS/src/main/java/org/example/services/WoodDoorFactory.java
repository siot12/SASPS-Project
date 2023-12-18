package org.example.services;

import org.example.model.Door;
import org.example.model.DoorMaterial;
import org.example.model.DoorWood;

public class WoodDoorFactory implements DoorFactory{
    @Override
    public Door createDoor(int height, int width) {
        return new DoorWood(height, width);
    }
}
