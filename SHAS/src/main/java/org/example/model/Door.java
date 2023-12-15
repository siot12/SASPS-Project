package org.example.model;

public class Door {

    private int height;
    private int wight;
    private DoorMaterial doorMaterial;

    public Door(int height, int wight, DoorMaterial doorMaterial) {
        this.height = height;
        this.wight = wight;
        this.doorMaterial = doorMaterial;
    }
}
