package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public boolean isWin() {
        return (ifwindiagonal1() || ifwindiagonal2() || ifwingorizontal() || ifwinvertical());
    }

    private boolean ifwindiagonal1() {
        int[][] table = this.convert();
        boolean result = false;
        if (!result) {
            for (int a = 0; a < this.size; a++) {
                if (table[a][a] == 1) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }

        return result;

    }

    private boolean ifwindiagonal2() {
        int[][] table = this.convert();
        boolean result = false;
        if (!result) {
            for (int a = 0; a < this.size; a++) {
                if (table[size - 1 - a][size - 1 - a] == 1) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    private boolean ifwinvertical() {
        int[][] table = this.convert();
        boolean result = false;
        for (int z = 0; z < this.size; z++) {
            if (!result) {
                for (int a = 0; a < this.size; a++) {
                    if (table[0 + z][a] == 1 & table[0 + z][size - 1 - a] == 1) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }

    private boolean ifwingorizontal() {
        int[][] table = this.convert();
        boolean result = false;
        for (int z = 0; z < this.size; z++) {
            if (!result) {
                for (int a = 0; a < this.size; a++) {
                    if (table[a][0 + z] == 1 & table[size - 1 - a][0 + z] == 1) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
