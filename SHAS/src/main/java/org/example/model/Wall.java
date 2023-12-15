package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private List<Window> windows;

    private Door door;

    public Wall(){
        windows = new ArrayList<>();
    }

    public List<Window> getWindows() {
        return windows;
    }

    public Door getDoor() {
        return door;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public static class WallBuilder {
        private Wall wall = new Wall();

        public WallBuilder window(Window window){
            wall.windows.add(window);
            return this;
        }

        public WallBuilder door(Door d){
            wall.setDoor(d);
            return this;
        }

        public Wall build(){
            return wall;
        }


    }
}
