package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление заявки"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new DeleteItem(2, "Delete item"));
        this.actions.add(new EditItem(3, "Edit item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);


    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        private final int key;
        private final String info;

        private AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }


        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Добавление заявки");
            String name = input.ask("name");
            String desc = input.ask("desc");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s - %s", key(), info);
        }
    }

    private class ShowItems implements UserAction {
        private final String info;
        private final int key;

        private ShowItems(int key, String info) {
            this.info = info;
            this.key = key;
        }

        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item a : tracker.findAll()) {
                System.out.println(a);
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key, this.info);
        }

    }

    private class DeleteItem implements UserAction {
        private final int key;
        private final String info;

        private DeleteItem(int key, String info) {
            this.key = key;
            this.info = info;
        }


        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.delete(input.ask("Введите ID заявки"));
        }

        @Override
        public String info() {
            return String.format("%s - %s", key(), info);
        }
    }

    private class EditItem implements UserAction {
        private final int key;
        private final String info;

        private EditItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            StartUI startUI = new StartUI(input, tracker);
            startUI.edit();
        }

        @Override
        public String info() {
            return String.format("%s - %s", key(), info);
        }
    }

    private class FindItemById implements UserAction {
        private final int key;
        private final String info;

        private FindItemById(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item a = tracker.findById(input.ask("Введи ID"));
            if (a == null) {
                System.out.println("Заявка не найдена");
            } else {
                System.out.println(a);
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", key(), info);
        }
    }

    private class FindItemsByName implements UserAction {
        private final int key;
        private final String info;

        private FindItemsByName(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] itemm = tracker.findByName(input.ask("Введите название заявки"));
            if (itemm.length != 0) {
                for (Item a : itemm) {
                    System.out.println(a);
                }
            } else {
                System.out.println("Не найдено");
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", key(), info);
        }
    }
}
