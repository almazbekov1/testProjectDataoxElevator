package com.company;

import java.util.ArrayList;
import java.util.List;

public class Floor {


    private int count = 0;
    private List<Person> people;
    private House house;

    public Floor(List<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person){
        if (people == null){
            people = new ArrayList<>();
        }
        people.add(person);
    }

    public Floor() {
    }

    public List<Person> getPeople() {
        return people;
    }


    public int getCount() {
        return count;
    }

    public void setCount() {
        count++;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void removePeople(List<Person> personRemove) {
        for (Person integer : personRemove) {
            people.remove(integer);
        }
    }
}
