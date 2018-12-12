package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
//    private int[] ranges = new int[]{0, 1, 2, 3, 4, 5};
    private int[] ranges(int iq) {
        int[] result = new int[iq];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", ranges(menu.getActionsLentgh())));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}