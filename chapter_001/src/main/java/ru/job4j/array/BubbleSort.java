package ru.job4j.array;

public class BubbleSort {
    public int[] bubblesort(int[] array) {
        int fin = array.length;
        for (int i = 1; fin >= 0; i++) {
            if (fin <= i) {
                fin--;
                i = 0;
            } else {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
        return array;
    }
}
