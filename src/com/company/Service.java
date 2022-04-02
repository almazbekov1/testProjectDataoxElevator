package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Service {

    public void nextStep(House house) {
        getOut(house);
        validate(house);
        getIn(house);
        validate(house);
        getIn(house);
        move(house);
    }

    public void startElevator(House house) {
        for (int i = 0; i < 10000; i++) {
            int count = 0;
            for (Floor floor : house.getFloors()) {
                count+=floor.getPeople().size();
            }
            count+=house.getElevator().getPeople().size();
            if (count==0){
                System.out.println("return");
                return;
            }
            nextStep(house);
        }
    }

    public int random(int wrongNumber, int min, int max) {
        Random random = new Random();
        max++;
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = random.nextInt(max - min) + min;
            if (num != wrongNumber) {
                return num;
            }
        }
        return num;
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

    private void setAimElevator(House house) {
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
        if (el.getFloor() == house.getFloors().size()) {
            el.setButton(Button.DOWN);
            return;
        } else if (el.getFloor() == 1) {
            el.setButton(Button.UP);
            return;
        }
        if (el.getFloor() < el.getAim()) {
            el.setButton(Button.UP);
        } else if (el.getFloor() > el.getAim()) {
            el.setButton(Button.DOWN);
        }
    }

    private void validate(House house) {
        Elevator el = house.getElevator();
        if (el.getAim() != el.getFloor() || house.getFloors().get(el.getFloor() - 1).getPeople().size() > 0) {
            return;
        }
        int middleFloor = house.getFloors().size() / 2;
        for (int i = 0; i < house.getFloors().size() - middleFloor; i++) {
            try {
                if (house.getFloors().get(middleFloor + i).getPeople().size() > 0) {
                    el.setAim(middleFloor + i );
                    return;

                } else if (house.getFloors().get(middleFloor - i).getPeople().size() > 0) {
                    el.setAim(middleFloor + i );
                    return;
                }
            } catch (Error e) {
                System.out.println("error");
            }
        }
    }

    private void move(House house) {
        house.print();
        Elevator el = house.getElevator();

        if (el.getButton() == Button.DOWN) {
            el.setFloor(el.getFloor() - 1);
        } else {
            el.setFloor(el.getFloor() + 1);
        }
    }

    private void getIn(House house) {
        Elevator el = house.getElevator();

        int currentFloor = el.getFloor() - 1;
        if (el.getPeople().size() <= 5) {
            int sizePeople = house.getFloors().get(currentFloor).getPeople().size();
            List<Person> personRemove = new ArrayList<>();
            for (int j = 0; j < sizePeople; j++) {
                if (el.getPeople().size() >= 5) {
                    break;
                }
                if (house.getFloors().get(currentFloor).getPeople().get(j).getHa() == el.getButton()) {
                    personRemove.add(house.getFloors().get(currentFloor).getPeople().get(j));
                    el.addPerson(house.getFloors().get(currentFloor).getPeople().get(j));
                }
            }
            el.setHappened("");
            for (Person person : el.getPeople()) {
                el.setHappened(el.getHappened() + " " + person.getAim());
            }
            house.getFloors().get(currentFloor).removePeople(personRemove);
        }
        setAimElevator(house);
    }
}
