package ru.job4j.max;

/**
 * @author or Kretov Alexandr (mailto:no mail)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * Выводит большее число.
     *
     * @param first  первое число.
     * @param second второе число.
     * @return Результат.
     */

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int maxx(int first, int second, int third) {
        Max proverka = new Max();
        int resProverka = proverka.max(first, second);
        int resTwoProverka = proverka.max(resProverka, third);
        return resTwoProverka;
    }

}
