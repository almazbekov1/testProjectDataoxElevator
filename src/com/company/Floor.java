package com.company;

import java.util.List;

public class Floor {


    private int count = 0;
    private List<Person> people;
    private int k = 0;
    private House house;

    public Floor(List<Person> people) {
//        k = people.size();
        this.people = people;
    }

    public Person getPerson(int index) {
        Person person = people.remove(index);
        return person;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Floor() {
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        count++;
    }

    public House getHouse() {
        return house;
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
