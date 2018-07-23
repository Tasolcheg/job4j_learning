package ru.job4j.calculator;

/**
 * Простой калькулятор.
 */
public class Calculator {
    private double result;

    /**
     * Сложение.
     *
     * @param first  число.
     * @param second число/
     * @return Результат.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычетание.
     *
     * @param first  число.
     * @param second число/
     * @return Результат.
     */
    public void minus(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление.
     *
     * @param first  число.
     * @param second число/
     * @return Результат.
     */
    public void delenie(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умножение.
     *
     * @param first  число.
     * @param second число/
     * @return Результат.
     */
    public void umnoj(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {
        return this.result;
    }
}

