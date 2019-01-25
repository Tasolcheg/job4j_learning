package ru.jobj.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker1Enum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Tracker1EnumTest {
    @Test
    public void trackerItemAddTest() {
        Tracker1Enum.INSTANCE.add(new Item("name", "desc", 99L));
        assertThat(Tracker1Enum.INSTANCE.getItems()[0].getName(), is("name"));
        assertThat(Tracker1Enum.INSTANCE.getItems()[0].getDescription(), is("desc"));
        Tracker1Enum.INSTANCE.delete(Tracker1Enum.INSTANCE.getItems()[0].getId());

    }

    @Test
    public void trackerfindByNameTest() {
        Tracker1Enum.INSTANCE.add(new Item("1name", "1desc", 99L));
        Tracker1Enum.INSTANCE.add(new Item("1name", "2desc", 99L));
        Tracker1Enum.INSTANCE.add(new Item("2name", "3desc", 99L));
        Tracker1Enum.INSTANCE.add(new Item("1name", "4desc", 99L));
        Tracker1Enum.INSTANCE.add(new Item("2name", "5desc", 99L));
        for (Item a : Tracker1Enum.INSTANCE.findByName("1name")) {
            assertThat(a.getName(), is("1name"));
        }
        for (Item a : Tracker1Enum.INSTANCE.findByName("2name")) {
            assertThat(a.getName(), is("2name"));
        }
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }

    }

    @Test
    public void trackerfindByIdTest() {
        Tracker1Enum.INSTANCE.add(new Item("name", "desc", 99L));
        assertThat(Tracker1Enum.INSTANCE.findById(Tracker1Enum.INSTANCE.findByName("name")[0].getId()).getDescription(), is("desc"));
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }
    }

    @Test
    public void trackerfindAllTest() {
        int i = 0;
        for (int x = 0; x <= 50; x++) {
            Tracker1Enum.INSTANCE.add(new Item(x + "name", x + "desc", 99L));
        }
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            assertThat(a.getName(), is(i + "name"));
            assertThat(a.getDescription(), is(i++ + "desc"));
        }
        assertThat(Tracker1Enum.INSTANCE.findAll().length, is(i));
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }
    }

    @Test
    public void trackerDeleteTest() {
        for (int x = 0; x <= 10; x++) {
            Tracker1Enum.INSTANCE.add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        assertThat(Tracker1Enum.INSTANCE.getItems()[2].getName(), is("2name")); // до удаления
        boolean result = Tracker1Enum.INSTANCE.delete(Tracker1Enum.INSTANCE.getItems()[2].getId());                  //удаление
        assertThat(Tracker1Enum.INSTANCE.getItems()[2].getName(), is("3name")); //после удаления
        assertThat(Tracker1Enum.INSTANCE.getItems().length, is(100)); //проверяем длинну (она имеет значение)
        assertThat(result, is(true));
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }
    }

    @Test
    public void trackerNotDeleteTest() {
        for (int x = 0; x <= 10; x++) {
            Tracker1Enum.INSTANCE.add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        boolean result = Tracker1Enum.INSTANCE.delete("123123");                  //удаление
        assertThat(Tracker1Enum.INSTANCE.getItems()[2].getName(), is("2name")); //после удаления
        assertThat(result, is(false));
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }
    }

    @Test
    public void trackerReplaceTest() {
        for (int i = 0; i <= 10; i++) {
            Tracker1Enum.INSTANCE.add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getName(), is("3name"));
        assertThat(Tracker1Enum.INSTANCE.findAll().length, is(11));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getCreate(), is(99L));
        String idd = Tracker1Enum.INSTANCE.getItems()[i].getId();
        boolean result = Tracker1Enum.INSTANCE.replace(Tracker1Enum.INSTANCE.getItems()[i].getId(), new Item("newname", "newdesc", 98L));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getName(), is("newname"));
        assertThat(Tracker1Enum.INSTANCE.findAll().length, is(11));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getId(), is(idd));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getCreate(), is(98L));
        assertThat(result, is(true));
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }
    }

    @Test
    public void trackerNotReplaceTest() {
        for (int i = 0; i <= 10; i++) {
            Tracker1Enum.INSTANCE.add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getName(), is("3name"));
        assertThat(Tracker1Enum.INSTANCE.findAll().length, is(11));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getCreate(), is(99L));
        String idd = Tracker1Enum.INSTANCE.getItems()[i].getId();
        boolean result = Tracker1Enum.INSTANCE.replace("123123", new Item("newname", "newdesc", 98L));
        assertThat(result, is(false));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getName(), is("3name"));
        assertThat(Tracker1Enum.INSTANCE.findAll().length, is(11));
        assertThat(Tracker1Enum.INSTANCE.getItems()[i].getCreate(), is(99L));
        for (Item a : Tracker1Enum.INSTANCE.findAll()) {
            Tracker1Enum.INSTANCE.delete(a.getId());
        }
    }
}
