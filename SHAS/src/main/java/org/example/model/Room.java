package org.example.model;

import java.util.List;

public class Room {


    List<Wall> walls;
    Floor floor;
    Ceiling ceiling;

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public static class RoomBuilder {
        private Room room = new Room();

        public RoomBuilder wall(Wall w) {
            room.getWalls().add(w);
            return this;
        }

        public RoomBuilder floor(Floor f) {
            room.setFloor(f);
            return this;
        }

        public RoomBuilder ceiling(Ceiling c) {
            room.setCeiling(c);
            return this;
        }

        public Room build() {
            return room;
        }

    }
}
