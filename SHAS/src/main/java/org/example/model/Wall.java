package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private List<Window> windows;

    private Door door;
    private int height;
    private int width;

    public Wall(){
        windows = new ArrayList<>();
    }

    public List<Window> getWindows() {
        return windows;
    }

    public Door getDoor() {
        return door;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "windows=" + windows +
                ", door=" + door +
                ", height=" + height +
                ", width=" + width +
                '}';
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

        public WallBuilder height(int h){
            wall.height = h;
            return this;
        }
        public WallBuilder width(int w){
            wall.width = w;
            return this;
        }
        public Wall build(){
            return wall;
        }


    }
}
