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
            String ttest = input.ask("Введите пункт меню");
            if (ttest.matches("\\D+") || ttest.equals("")) {
                System.out.println("Неверный ввод");
            } else {
                Integer kkey = Integer.valueOf(ttest);

                if (kkey < menu.getActionsLentgh()) {
                    menu.select(kkey);
                }
            }
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}