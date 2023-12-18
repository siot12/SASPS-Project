package org.example.model;

public class Ceiling {
    int length;
    int width;
    public Ceiling(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Ceiling{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
