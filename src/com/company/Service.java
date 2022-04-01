package com.company;

import java.util.ArrayList;
import java.util.List;


public class Service {

    public static int step = 1;

    public void nextStep(Elevator el, House house) {
        List<Floor> floors = house.getFloors();
        if (el.getFloor() > el.getAim()) {
            el.setButton(Button.DOWN);
        } else if (el.getFloor() < el.getAim()) {
            el.setButton(Button.UP);
        }

        if (el.getFloor() == 0) {
            el.setFloor(el.getFloor() + 1);
        } else if (el.getFloor() == floors.size()) {
            el.setFloor(el.getFloor() - 1);
        } else if (el.getButton() == Button.UP) {
            el.setFloor(el.getFloor() + 1);
        } else if (el.getButton() == Button.DOWN) {
            el.setFloor(el.getFloor() - 1);
        }
        changeFloor(house, el);
        getIn(house,el);
        getOut(house,el);


    }

    private void getOut(House house, Elevator el) {
        
    }

    private void getIn(House house, Elevator el) {

        if (el.getButton()==Button.UP){
            for (Person person : el.getPeople()) {
                if (person.getAim()>el.getAim()){
                    el.setAim(person.getAim());
                }
            }
        }else {
            for (Person person : el.getPeople()) {
                if (person.getAim()<el.getAim()){
                    el.setAim(person.getAim());
                }
            }

        }

    }

    private void changeFloor(House house, Elevator el) {
        for (int i = 0; i < house.getFloors().size(); i++) {
            if (i == el.getFloor()) {
                if (el.getPeople().size() <= 5) {
                    int sizePeople = house.getFloors().get(i).getPeople().size();
                    List<Person> personRemove = new ArrayList<>();
                    for (int j = 0; j < sizePeople; j++) {
                        if (house.getFloors().get(i).getPeople().get(j).getHa() == el.getButton()) {
                            personRemove.add(house.getFloors().get(i).getPeople().get(j));
                            el.addPerson(house.getFloors().get(i).getPeople().get(j));
                            if (el.getPeople().size() >= 5) {
                                break;
                            }
                        }
                    }
                    for (Person person : personRemove) {
                        el.setHappened(el.getHappened()+person.getAim()+" ");
                    }
                    house.getFloors().get(i).removePeople(personRemove);
                }
            }
        }
    }
}
