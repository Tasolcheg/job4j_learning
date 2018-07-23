package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] stringsort(String[] array) {
        int fin = 0;
        for (int i = 0; i < array.length; i++) {
            for (int x = 0; x < array.length; x++) {
                if (i != x && array[i].equals(array[x])) {
                    if (i > x) {
                        break;
                    } else {
                        array[fin++] = array[x];
                        break;
                    }
                } else {
                    if (i <= x) {
                        array[fin++] = array[i];
                        break;
                    }
                }
            }
        }
        return Arrays.copyOf(array, fin);
    }
}


