package ru.job4j.loop;

public class Counter {
    public int counter(int start, int finish) {
        int result = 0;
        for (int x = start; x <= finish; x++) {
            if (x % 2 == 0) {
                result += x;
            }
        }
        return result;
    }
}
