package org.example.run;

import org.example.controller.SmartHomeControllerWithObserver;
import org.example.model.*;
import org.example.services.DoorFactory;
import org.example.services.SteelDoorFactory;
import org.example.services.WoodDoorFactory;

import java.util.List;
import java.util.Scanner;

public class CreateApp {
    static SmartHomeControllerWithObserver controller = new SmartHomeControllerWithObserver();

    static DoorFactory doorFactory;

    static List<Device> devices = List.of(new Device("Termostat"), new Device("Bec"), new Device("Intrerupator"));

    public static void main(String[] args) {
        while (true) {
            int cmd = printMenu();
            if (cmd == 0) {
                System.out.println("Bye!!!");
                return;
            }
            if (cmd == 1) {
                Room.RoomBuilder roomBuilder = new Room.RoomBuilder();
                while (true) {
                    System.out.println("0. Back");
                    System.out.println("1. Add wall");
                    System.out.println("2. Add floor & ceiling");
                    System.out.println("3. Add device");
                    System.out.println("4. Save");
                    System.out.println(">>");
                    Scanner sc = new Scanner(System.in);
                    int cmd2 = sc.nextInt();
                    if (cmd2 == 0) {
                        break;
                    }
                    if (cmd2 == 1) {
                        Wall.WallBuilder wallBuilder = new Wall.WallBuilder();
                        System.out.println("Enter height:");
                        int height = sc.nextInt();
                        wallBuilder.height(height);
                        System.out.println("Enter width:");
                        int width = sc.nextInt();
                        wallBuilder.width(width);
                        System.out.println("Enter number of default windows: ");
                        int nrWindows = sc.nextInt();
                        for (int i = 0; i < nrWindows; i++) {
                            wallBuilder.window(new Window());
                        }
                        System.out.println("4. Add door(optionally)");
                        System.out.println("Yes/No");
                        String yes = sc.next();
                        if (yes.equals("Yes")) {
                            System.out.println("If you want a wood door enter 0. If you want a steel door enter 1: ");
                            int materialId = sc.nextInt();
                            if (materialId == 0) {
                                doorFactory = new WoodDoorFactory();
                            } else {
                                doorFactory = new SteelDoorFactory();
                            }
                            System.out.println("Enter height:");
                            int doorHeight = sc.nextInt();
                            System.out.println("Enter width:");
                            int doorWidth = sc.nextInt();
                            wallBuilder.door(doorFactory.createDoor(doorHeight, doorWidth));
                        }
                        roomBuilder.wall(wallBuilder.build());
                    } else if (cmd2 == 2) {
                        System.out.println("Enter length:");
                        int length = sc.nextInt();
                        System.out.println("Enter width:");
                        int width = sc.nextInt();
                        roomBuilder.ceiling(new Ceiling(length, width)).floor(new Floor(length, width));
                    } else if (cmd2 == 3) {
                        System.out.println("Available devices:");
                        for (int i = 0; i < devices.size(); i++) {
                            System.out.println(i + " " + devices.get(i));
                        }
                        System.out.println("Enter number of device");
                        int deviceNr = sc.nextInt();
                        devices.get(deviceNr).addObserver(roomBuilder.build());
                    } else if (cmd2 == 4) {
                        controller.addRoom(roomBuilder.build());
                        System.out.println("Room " + roomBuilder.build() + " saved successfully ");
                        break;
                    } else {
                        System.out.println("Invalid cmd");
                        break;
                    }

                }
            }
            if (cmd == 2) {
                devices.forEach(System.out::println);
            }
            if (cmd == 3) {
                devices.forEach(Device::turnOn);
            }
            if (cmd == 4) {
                devices.forEach(Device::turnOff);
            }
        }

    }

    private static int printMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Add room");
        System.out.println("2. Show devices");
        System.out.println("3. Turn on devices");
        System.out.println("4. Turn off devices");
        System.out.println(">>");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}