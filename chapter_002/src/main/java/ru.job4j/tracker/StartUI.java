package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String ALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для Удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска заявок по имени.
     */
    private static final String FINDITEMBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.findALL();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findbyid();
            } else if (FINDITEMBYNAME.equals(answer)) {
                this.finditembyname();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("XXXX Неверный выбор XXXX");
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
            }
        }
    }


    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("Добавление новой заявки");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с Id : " + item.getId());
    }

    private void findALL() {
        System.out.println("Все заявки");
        for (Item a : this.tracker.findAll()) {
            System.out.println(a);
        }
    }

    private void edit() {
        System.out.println("Редактирование заяки");
        String id = input.ask("Введите id");
        String name = input.ask("Введите новое название");
        String desc = input.ask("Введите новое описание");
        Boolean res = this.tracker.replace(id, new Item(name, desc));
        if (res) {
            System.out.println("Заявка изменена");
        } else {
            System.out.println("ID не найдено");
        }
    }

    private void delete() {
        System.out.println("Удаление по id");
        String id = input.ask("Введите id");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("ID не найден");
        }
    }

    private void findbyid() {
        System.out.println("Поиск по id");
        Item result = this.tracker.findById(input.ask("Введите id"));
        if (result == null) {
            System.out.println("Заявка не найдена");
        } else {
            System.out.println(result.toString());
        }
    }

    private void finditembyname() {
        System.out.println("Поиск по id");
        Item[] result = this.tracker.findByName(input.ask("Введите название заявки"));
        for (Item a : result) {
            System.out.println(a.toString());
        }
    }

    private void showMenu() {
        System.out.println("##########################");
        System.out.println("#         Меню.          #");
        System.out.println("#  0. Add new Item       #");
        System.out.println("#  1. Show all items     #");
        System.out.println("#  2. Edit item          #");
        System.out.println("#  3. Delete item        #");
        System.out.println("#  4. Find item by Id    #");
        System.out.println("#  5. Find items by name #");
        System.out.println("#  6. Exit Program       #");
        System.out.println("##########################");


    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}