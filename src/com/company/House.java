package com.company;


import java.util.List;

public class House {

    private  int step = 0;
    private List<Floor> floors;
    private Elevator elevator;

    public House(List<Floor> floors) {
        this.floors = floors;
        this.elevator = new Elevator();
        for (Floor floor : floors) {
            floor.setHouse(this);
        }
    }



    public void print() {
        Elevator el = elevator;
        System.out.println("***   step " + step++ + "   ***");
        int count = floors.size();
        String s = " ";
        for (int i = floors.size() - 1; i >= 0; i--) {
            if (count == el.getFloor()) {
                s = el.getButton().getSymbol() + " " + el.getHappened();
            }
            for (int j = s.length(); j < 15; j++) {
                s += " ";
            }
            count--;
            System.out.println(floors.get(i).getCount() + "|" + s + "       | " + getSizePeopleFloor(floors.get(i)));
            s = " ";
        }
        System.out.println();
    }

    private String getSizePeopleFloor(Floor floor) {
        String s = "";
        if (floor.getPeople() != null) {
            for (Person person : floor.getPeople()) {
                if (person != null) {
                    s += person.getAim() + " ";
                }
            }
        }
        return s;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Elevator getElevator() {
        return elevator;
    }
}
