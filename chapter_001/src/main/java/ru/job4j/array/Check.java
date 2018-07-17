package ru.job4j.array;

public class Check {
    public boolean mono (boolean[] data) {
        boolean result = false;
        int ind = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                ind++;
            } else {
                ind--;
            }
        }
        if (ind == data.length || ind == data.length * -1){
            result = true;
        }
        return result;
    }
}
