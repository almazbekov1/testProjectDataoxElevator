package com.company;


import java.util.List;

public class House {

    private static int step = 1;
    private List<Floor> floors;
    private String n = "house test";

    public House(List<Floor> floors) {
        this.floors = floors;
        for (Floor floor : floors) {
            floor.setHouse(this);
        }
    }

    public Floor get(int index) {
        return floors.get(index);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }


    public void toString(Elevator el) {
        System.out.println("***   step " + step++ + "   ***");
        int count = floors.size()-1;
        String s = " ";
        for (int i = floors.size() - 1; i >= 0; i--) {
//            System.out.println(count);
//            System.out.println(el.getFloor());
            if (count == el.getFloor()) {
//                System.out.println("if");
                s = el.getButton().getSymbol()+" "+el.getHappened();
            }
            for (int j = s.length(); j < 12; j++) {
                s+=" ";
            }
            count--;
            System.out.println("0|" + s  + "       | " + getSizePeopleFloor(floors.get(i)));
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

}
