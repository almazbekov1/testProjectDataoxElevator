package com.company;


import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private int floor = 1;
    private List<Person> people = new ArrayList<>();
    private Button button = Button.UP;
    private int aim = 2;
    private String happened = "";


    public void addPerson(Person person) {
        people.add(person);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void getPerson(Person person) {
        System.out.println(people.size()+" sdlfjdf");
        people.remove(person);
        System.out.println(people.size());
//        return person;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }



    public String getHappened() {
        return happened;
    }

    public void setHappened(String happened) {
        this.happened = happened;
    }

    public void removePeople(List<Person> peopleRemove) {
        for (Person person : peopleRemove) {
            people.remove(person);
        }
    }
}
