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
    String menu = new StringBuilder()
            .append("0 - Добавление заявки")
            .append(System.lineSeparator())
            .append("1 - Show all items")
            .append(System.lineSeparator())
            .append("2 - Delete item")
            .append(System.lineSeparator())
            .append("3 - Edit item")
            .append(System.lineSeparator())
            .append("4 - Find item by Id")
            .append(System.lineSeparator())
            .append("5 - Find items by name")
            .append(System.lineSeparator())
            .toString();

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
        Input input = new StubInput(new String[]{"0", "name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(menu)
                .append("Добавление заявки")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect1() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(menu)
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
                .toString()));

    }

    @Test
    public void whenSelect3() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"3", "1234", "name", "desc", "n", "3", "1235", "name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(menu)
                .append("Редактирование заяки")
                .append(System.lineSeparator())
                .append("ID не найдено")
                .append(System.lineSeparator())
                .append(menu)
                .append("Редактирование заяки")
                .append(System.lineSeparator())
                .append("Заявка изменена")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"3", "1234", "name", "desc", "n", "3", "1235", "name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(menu)
                .append("Редактирование заяки")
                .append(System.lineSeparator())
                .append("ID не найдено")
                .append(System.lineSeparator())
                .append(menu)
                .append("Редактирование заяки")
                .append(System.lineSeparator())
                .append("Заявка изменена")
                .append(System.lineSeparator())
                .toString()));

    }

    @Test
    public void whenSelect4() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc1"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"4", "1234", "n", "4", "1235", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(menu)
                .append("Заявка не найдена")
                .append(System.lineSeparator())
                .append(menu)
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
                .toString()));

    }

    @Test
    public void whenSelect5() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        item.setId("1235");
        Input input = new StubInput(new String[]{"5", "test", "n", "5", "test name", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(menu)
                .append("Не найдено")
                .append(System.lineSeparator())
                .append(menu)
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
                .toString()));

    }
}