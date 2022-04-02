package com.company;

public enum Button {
    UP('↑'),
    DOWN('↓');
    private char symbol;

    Button(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
