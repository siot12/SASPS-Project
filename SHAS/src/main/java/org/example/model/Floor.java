package org.example.model;

public class Floor {
    int length;
    int width;
    public Floor(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
