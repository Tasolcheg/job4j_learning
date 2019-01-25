package ru.jobj.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker4StaticFinalClass;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Tracker4StaticFinalClassTest {
    @Test
    public void trackerItemAddTest() {
        Tracker4StaticFinalClass.getInstance().add(new Item("name", "desc", 99L));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[0].getName(), is("name"));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[0].getDescription(), is("desc"));
        Tracker4StaticFinalClass.getInstance().delete(Tracker4StaticFinalClass.getInstance().getItems()[0].getId());

    }

    @Test
    public void trackerfindByNameTest() {
        Tracker4StaticFinalClass.getInstance().add(new Item("1name", "1desc", 99L));
        Tracker4StaticFinalClass.getInstance().add(new Item("1name", "2desc", 99L));
        Tracker4StaticFinalClass.getInstance().add(new Item("2name", "3desc", 99L));
        Tracker4StaticFinalClass.getInstance().add(new Item("1name", "4desc", 99L));
        Tracker4StaticFinalClass.getInstance().add(new Item("2name", "5desc", 99L));
        for (Item a : Tracker4StaticFinalClass.getInstance().findByName("1name")) {
            assertThat(a.getName(), is("1name"));
        }
        for (Item a : Tracker4StaticFinalClass.getInstance().findByName("2name")) {
            assertThat(a.getName(), is("2name"));
        }
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }

    }

    @Test
    public void trackerfindByIdTest() {
        Tracker4StaticFinalClass.getInstance().add(new Item("name", "desc", 99L));
        assertThat(Tracker4StaticFinalClass.getInstance().findById(Tracker4StaticFinalClass.getInstance().findByName("name")[0].getId()).getDescription(), is("desc"));
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerfindAllTest() {
        int i = 0;
        for (int x = 0; x <= 50; x++) {
            Tracker4StaticFinalClass.getInstance().add(new Item(x + "name", x + "desc", 99L));
        }
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            assertThat(a.getName(), is(i + "name"));
            assertThat(a.getDescription(), is(i++ + "desc"));
        }
        assertThat(Tracker4StaticFinalClass.getInstance().findAll().length, is(i));
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerDeleteTest() {
        for (int x = 0; x <= 10; x++) {
            Tracker4StaticFinalClass.getInstance().add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[2].getName(), is("2name")); // до удаления
        boolean result = Tracker4StaticFinalClass.getInstance().delete(Tracker4StaticFinalClass.getInstance().getItems()[2].getId());                  //удаление
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[2].getName(), is("3name")); //после удаления
        assertThat(Tracker4StaticFinalClass.getInstance().getItems().length, is(100)); //проверяем длинну (она имеет значение)
        assertThat(result, is(true));
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerNotDeleteTest() {
        for (int x = 0; x <= 10; x++) {
            Tracker4StaticFinalClass.getInstance().add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        boolean result = Tracker4StaticFinalClass.getInstance().delete("123123");                  //удаление
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[2].getName(), is("2name")); //после удаления
        assertThat(result, is(false));
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerReplaceTest() {
        for (int i = 0; i <= 10; i++) {
            Tracker4StaticFinalClass.getInstance().add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getName(), is("3name"));
        assertThat(Tracker4StaticFinalClass.getInstance().findAll().length, is(11));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getCreate(), is(99L));
        String idd = Tracker4StaticFinalClass.getInstance().getItems()[i].getId();
        boolean result = Tracker4StaticFinalClass.getInstance().replace(Tracker4StaticFinalClass.getInstance().getItems()[i].getId(), new Item("newname", "newdesc", 98L));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getName(), is("newname"));
        assertThat(Tracker4StaticFinalClass.getInstance().findAll().length, is(11));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getId(), is(idd));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getCreate(), is(98L));
        assertThat(result, is(true));
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerNotReplaceTest() {
        for (int i = 0; i <= 10; i++) {
            Tracker4StaticFinalClass.getInstance().add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getName(), is("3name"));
        assertThat(Tracker4StaticFinalClass.getInstance().findAll().length, is(11));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getCreate(), is(99L));
        String idd = Tracker4StaticFinalClass.getInstance().getItems()[i].getId();
        boolean result = Tracker4StaticFinalClass.getInstance().replace("123123", new Item("newname", "newdesc", 98L));
        assertThat(result, is(false));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getName(), is("3name"));
        assertThat(Tracker4StaticFinalClass.getInstance().findAll().length, is(11));
        assertThat(Tracker4StaticFinalClass.getInstance().getItems()[i].getCreate(), is(99L));
        for (Item a : Tracker4StaticFinalClass.getInstance().findAll()) {
            Tracker4StaticFinalClass.getInstance().delete(a.getId());
        }
    }
}
