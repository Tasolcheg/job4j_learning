package ru.jobj.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenSelect0() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Добавление новой заявки")
                .append(System.lineSeparator())
                .append("Новая заявка с Id : " + tracker.getItems()[0].getId())
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect1() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Все заявки")
                .append(System.lineSeparator())
                .append("ID заявки")
                .append(System.lineSeparator())
                .append("1235")
                .append(System.lineSeparator())
                .append("Название заявки")
                .append(System.lineSeparator())
                .append("test name")
                .append(System.lineSeparator())
                .append("Описание заявки")
                .append(System.lineSeparator())
                .append("desc")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"2", "1234", "name", "desc", "2", "1235", "name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Редактирование заяки")
                .append(System.lineSeparator())
                .append("ID не найдено")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Редактирование заяки")
                .append(System.lineSeparator())
                .append("Заявка изменена")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect3() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"3", "1234", "3", "1235", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Удаление по id")
                .append(System.lineSeparator())
                .append("ID не найден")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Удаление по id")
                .append(System.lineSeparator())
                .append("Заявка удалена")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect4() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc1"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"4", "1234", "4", "1235", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Поиск по id")
                .append(System.lineSeparator())
                .append("Заявка не найдена")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Поиск по id")
                .append(System.lineSeparator())
                .append("ID заявки")
                .append(System.lineSeparator())
                .append("1235")
                .append(System.lineSeparator())
                .append("Название заявки")
                .append(System.lineSeparator())
                .append("test name1")
                .append(System.lineSeparator())
                .append("Описание заявки")
                .append(System.lineSeparator())
                .append("desc1")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect5() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"5", "test name", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("Поиск по id")
                .append(System.lineSeparator())
                .append("ID заявки")
                .append(System.lineSeparator())
                .append("1235")
                .append(System.lineSeparator())
                .append("Название заявки")
                .append(System.lineSeparator())
                .append("test name")
                .append(System.lineSeparator())
                .append("Описание заявки")
                .append(System.lineSeparator())
                .append("desc")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect6() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("##########################")
                .append(System.lineSeparator())
                .append("#         Меню.          #")
                .append(System.lineSeparator())
                .append("#  0. Add new Item       #")
                .append(System.lineSeparator())
                .append("#  1. Show all items     #")
                .append(System.lineSeparator())
                .append("#  2. Edit item          #")
                .append(System.lineSeparator())
                .append("#  3. Delete item        #")
                .append(System.lineSeparator())
                .append("#  4. Find item by Id    #")
                .append(System.lineSeparator())
                .append("#  5. Find items by name #")
                .append(System.lineSeparator())
                .append("#  6. Exit Program       #")
                .append(System.lineSeparator())
                .append("##########################")
                .append(System.lineSeparator())
                .toString()));

    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();     // создаём Tracker
        //Напрямую добавляем заявки
        tracker.add(new Item("test name1", "desc"));
        tracker.add(new Item("test name2", "desc"));
        tracker.add(new Item("test name3", "desc"));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"3", tracker.getItems()[1].getId(), "6"});
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().length, is(2));
    }

}