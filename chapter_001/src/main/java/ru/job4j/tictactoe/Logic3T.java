package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[0][0].hasMarkX() && this.table[i][i].hasMarkX()
                    || this.table[0][this.table.length - 1].hasMarkX()
                    && this.table[i][this.table.length - 1 - i].hasMarkX()) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        for (int i = 0; i < this.table.length; i++) {
            if (result) {
                break;
            } else {
                for (int x = 0; x < this.table.length; x++) {
                    if (this.table[x][i].hasMarkX() && this.table[0][i].hasMarkX()){
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < this.table.length; i++) {
            if (result) {
                break;
            } else {
                for (int x = 0; x < this.table.length; x++) {
                    if (this.table[i][x].hasMarkX() && this.table[i][0].hasMarkX()){
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[0][0].hasMarkO() && this.table[i][i].hasMarkO()
                    || this.table[0][this.table.length - 1].hasMarkO()
                    && this.table[i][this.table.length - 1 - i].hasMarkO()) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        for (int i = 0; i < this.table.length; i++) {
            if (result) {
                break;
            } else {
                for (int x = 0; x < this.table.length; x++) {
                    if (this.table[x][i].hasMarkO() && this.table[0][i].hasMarkO()){
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < this.table.length; i++) {
            if (result) {
                break;
            } else {
                for (int x = 0; x < this.table.length; x++) {
                    if (this.table[i][x].hasMarkO() && this.table[i][0].hasMarkO()){
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int z = 0; z < this.table.length; z++) {
            if (!result) {
                for (int c = 0; c < this.table.length; c++) {
                    if (!this.table[z][c].hasMarkX() && !this.table[z][c].hasMarkO()) {
                        result = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }
}