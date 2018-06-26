package ru.job4j.loop;

public class Factorial {
    public int factorial (int chisl) {
        int result = 1;
        for (int x = 1; x <= chisl; x++){
            result *= x;
        }
        return result;
    }
}