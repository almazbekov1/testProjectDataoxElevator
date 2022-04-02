package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();

        int maxFloor = service.random(0, 5, 20);
        List<Floor>  floors = new ArrayList<>();
        for (int i = 1; i <= maxFloor; i++) {
            Floor floor = new Floor();
            for (int j = 0; j < service.random(0, 0, 10); j++) {
                floor.addPerson(new Person(service.random(i, 1, maxFloor), i));
            }
            floors.add(floor);
        }

        House house = new House(floors);
        house.print();

        service.startElevator(house);

    }

}
