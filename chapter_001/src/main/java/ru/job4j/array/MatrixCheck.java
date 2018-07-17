package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result;
        int resL = 0;
        int resR = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][i] == data[0][0]) {
                resL++;
            }
            if (data[0][data.length - 1] == data[i][data.length - 1 - i]) {
                resR++;
            }

        }
        if (resL == data.length || resR == data.length) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
