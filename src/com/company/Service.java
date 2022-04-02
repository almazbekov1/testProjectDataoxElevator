package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Service {




    public void nextStep( House house) {
        change(house);
        getOut(house);
        getIn(house);
        change2(house);
        checkButton(house);
        move(house);
    }

    private void getOut(House house) {
        Elevator el = house.getElevator();
        List<Person> peopleRemove = new ArrayList<>();
        for (Person person : el.getPeople()) {
            if (person.getAim() == el.getFloor()) {
                house.getFloors().get(el.getFloor() - 1).setCount();
                peopleRemove.add(person);
            }
        }
        el.removePeople(peopleRemove);

    }

    private void checkButton(House house) {
        Elevator el = house.getElevator();
        if (el.getButton() == Button.UP) {
            for (Person person : el.getPeople()) {
                if (person.getAim() > el.getAim()) {
                    el.setAim(person.getAim());
                }
            }
        } else {
            for (Person person : el.getPeople()) {
                if (person.getAim() < el.getAim()) {
                    el.setAim(person.getAim());
                }
            }

        }

    }

    private void change(House house) {
        Elevator el = house.getElevator();
        if (el.getButton() == Button.UP) {
            int count = 0;
            for (Person person : el.getPeople()) {
                if (person.getAim() > el.getFloor()) {
                    count++;
                }
            }
            if (count == 0) {
                el.setButton(Button.DOWN);
            }
        } else {
            int count = 0;
            for (Person person : el.getPeople()) {
                if (person.getAim() < el.getFloor()) {
                    count++;
                }
            }
            if (count == 0) {
                el.setButton(Button.UP);
            }
        }


        if (el.getFloor() > el.getAim()) {
            el.setButton(Button.DOWN);
        } else if (el.getFloor() < el.getAim()) {
            el.setButton(Button.UP);
        }
        List<Floor> floors = house.getFloors();
//        if (el.getFloor() == 1) {
//            el.setFloor(el.getFloor() + 1);
//        } else if (el.getFloor() == floors.size()) {
//            el.setFloor(el.getFloor() - 1);
//        } else if (el.getButton() == Button.UP) {
//            el.setFloor(el.getFloor() + 1);
//        } else if (el.getButton() == Button.DOWN) {
//            el.setFloor(el.getFloor() - 1);
//        }
    }
    private void move(House house){
        Elevator el = house.getElevator();
        el.setFloor(el.getFloor() + 1);
    }

    private void change2(House house) {
        Elevator el = house.getElevator();
        if (el.getButton() == Button.UP) {
            int count = 0;
            for (Person person : el.getPeople()) {
                if (person.getAim() > el.getFloor()) {
                    count++;
                }
            }
            if (count == 0) {
                el.setButton(Button.DOWN);
                getIn(house);
            }
        } else {
            int count = 0;
            for (Person person : el.getPeople()) {
                if (person.getAim() < el.getFloor()) {
                    count++;
                }
            }
            if (count == 0) {
                el.setButton(Button.UP);
                getIn(house);
            }
        }


        if (el.getFloor() > el.getAim()) {
            el.setButton(Button.DOWN);
        } else if (el.getFloor() < el.getAim()) {
            el.setButton(Button.UP);
        }
    }

    private void getIn(House house) {
        Elevator el = house.getElevator();
        int currentFloor = el.getFloor() - 1;
        if (el.getPeople().size() <= 5) {
            int sizePeople = house.getFloors().get(currentFloor).getPeople().size();
            List<Person> personRemove = new ArrayList<>();
            for (int j = 0; j < sizePeople; j++) {
                if (house.getFloors().get(currentFloor).getPeople().get(j).getHa() == el.getButton()) {
                    personRemove.add(house.getFloors().get(currentFloor).getPeople().get(j));
                    el.addPerson(house.getFloors().get(currentFloor).getPeople().get(j));
                    if (el.getPeople().size() >= 5) {
                        break;
                    }
                }
            }
            el.setHappened("");
            for (Person person : el.getPeople()) {
                el.setHappened(el.getHappened() + " " + person.getAim());
            }
            house.getFloors().get(currentFloor).removePeople(personRemove);

        }

    }
}
