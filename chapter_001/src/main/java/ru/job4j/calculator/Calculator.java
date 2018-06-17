package ru.job4j.calculator;

public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }
    public void minus(double first, double second) {
        this.result = first - second;
    }
    public void delenie(double first, double second) {
        this.result = first / second;
    }
    public void umnoj(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {
        return this.result;
    }
}

