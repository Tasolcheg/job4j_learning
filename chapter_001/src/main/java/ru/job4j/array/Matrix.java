package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++){
            for (int e = 0; e < table.length; e++){
                table[i][e] = (i + 1) * (e + 1);
            }
        }
        return table;
    }
}