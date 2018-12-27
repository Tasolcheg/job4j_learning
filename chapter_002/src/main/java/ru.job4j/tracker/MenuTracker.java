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

    private class AddItem extends BaseAction {

        private AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Добавление заявки");
            String name = input.ask("name");
            String desc = input.ask("desc");
            tracker.add(new Item(name, desc));
        }
    }

    private class ShowItems extends BaseAction {

        private ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item a : tracker.findAll()) {
                System.out.println(a);
            }
        }
    }

    private class DeleteItem extends BaseAction {

        private DeleteItem(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.delete(input.ask("Введите ID заявки"));
        }
    }

    private class EditItem extends BaseAction {

        private EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Редактирование заяки");
            String id = input.ask("Введите id");
            String name = input.ask("Введите новое название");
            String desc = input.ask("Введите новое описание");
            Boolean res = tracker.replace(id, new Item(name, desc));
            if (res) {
                System.out.println("Заявка изменена");
            } else {
                System.out.println("ID не найдено");
            }
        }

    }

    private class FindItemById extends BaseAction {

        private FindItemById(int key, String name) {
            super(key, name);
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
    }

    private class FindItemsByName extends BaseAction {

        private FindItemsByName(int key, String name) {
            super(key, name);
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
    }
}
