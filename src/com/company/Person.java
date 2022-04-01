package com.company;


public class Person {

    private int aim;
    private Button button;

    public Person() {
    }

    public Person(int aim, int currentFloor) {
        this.aim = aim;
        if (currentFloor< aim){
            button = button.UP;}else button = button.DOWN;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public Button getHa() {
        return button;
    }

    public void setHa(Button button) {
        this.button = button;
    }
}
