package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();

        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor(new ArrayList<>(List.of(new Person(2, 1), new Person(4, 1), new Person(3, 1), new Person(3, 1)))));
        floors.add(new Floor(new ArrayList<>(List.of(new Person(4, 2), new Person(5, 2), new Person(1, 2), new Person(4, 2)))));
        floors.add(new Floor(new ArrayList<>(List.of(new Person(2, 3)))));
        floors.add(new Floor(new ArrayList<>(List.of(new Person(3, 4), new Person(2, 4), new Person(5, 4),new Person(1, 4)))));
        floors.add(new Floor(new ArrayList<>(List.of(new Person(2, 5), new Person(4, 5)))));
        House house = new House(floors);
        Elevator el = new Elevator();
        house.toString(el);

        service.nextStep(el, house);
        house.toString(el);

        service.nextStep(el, house);
        house.toString(el);
//        floors.get(0).getPeople().remove(2);
//
//        System.out.println(house.getFloors().get(0).getPeople().size());



    }


}
