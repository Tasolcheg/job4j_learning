package ru.jobj.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker3StaticFinalField;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Tracker3StaticFinalFieldTest {
    @Test
    public void trackerItemAddTest() {
        Tracker3StaticFinalField.getInstance().add(new Item("name", "desc", 99L));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[0].getName(), is("name"));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[0].getDescription(), is("desc"));
        Tracker3StaticFinalField.getInstance().delete(Tracker3StaticFinalField.getInstance().getItems()[0].getId());

    }

    @Test
    public void trackerfindByNameTest() {
        Tracker3StaticFinalField.getInstance().add(new Item("1name", "1desc", 99L));
        Tracker3StaticFinalField.getInstance().add(new Item("1name", "2desc", 99L));
        Tracker3StaticFinalField.getInstance().add(new Item("2name", "3desc", 99L));
        Tracker3StaticFinalField.getInstance().add(new Item("1name", "4desc", 99L));
        Tracker3StaticFinalField.getInstance().add(new Item("2name", "5desc", 99L));
        for (Item a : Tracker3StaticFinalField.getInstance().findByName("1name")) {
            assertThat(a.getName(), is("1name"));
        }
        for (Item a : Tracker3StaticFinalField.getInstance().findByName("2name")) {
            assertThat(a.getName(), is("2name"));
        }
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }

    }

    @Test
    public void trackerfindByIdTest() {
        Tracker3StaticFinalField.getInstance().add(new Item("name", "desc", 99L));
        assertThat(Tracker3StaticFinalField.getInstance().findById(Tracker3StaticFinalField.getInstance().findByName("name")[0].getId()).getDescription(), is("desc"));
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerfindAllTest() {
        int i = 0;
        for (int x = 0; x <= 50; x++) {
            Tracker3StaticFinalField.getInstance().add(new Item(x + "name", x + "desc", 99L));
        }
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            assertThat(a.getName(), is(i + "name"));
            assertThat(a.getDescription(), is(i++ + "desc"));
        }
        assertThat(Tracker3StaticFinalField.getInstance().findAll().length, is(i));
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerDeleteTest() {
        for (int x = 0; x <= 10; x++) {
            Tracker3StaticFinalField.getInstance().add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[2].getName(), is("2name")); // до удаления
        boolean result = Tracker3StaticFinalField.getInstance().delete(Tracker3StaticFinalField.getInstance().getItems()[2].getId());                  //удаление
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[2].getName(), is("3name")); //после удаления
        assertThat(Tracker3StaticFinalField.getInstance().getItems().length, is(100)); //проверяем длинну (она имеет значение)
        assertThat(result, is(true));
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerNotDeleteTest() {
        for (int x = 0; x <= 10; x++) {
            Tracker3StaticFinalField.getInstance().add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        boolean result = Tracker3StaticFinalField.getInstance().delete("123123");                  //удаление
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[2].getName(), is("2name")); //после удаления
        assertThat(result, is(false));
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerReplaceTest() {
        for (int i = 0; i <= 10; i++) {
            Tracker3StaticFinalField.getInstance().add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getName(), is("3name"));
        assertThat(Tracker3StaticFinalField.getInstance().findAll().length, is(11));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getCreate(), is(99L));
        String idd = Tracker3StaticFinalField.getInstance().getItems()[i].getId();
        boolean result = Tracker3StaticFinalField.getInstance().replace(Tracker3StaticFinalField.getInstance().getItems()[i].getId(), new Item("newname", "newdesc", 98L));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getName(), is("newname"));
        assertThat(Tracker3StaticFinalField.getInstance().findAll().length, is(11));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getId(), is(idd));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getCreate(), is(98L));
        assertThat(result, is(true));
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }
    }

    @Test
    public void trackerNotReplaceTest() {
        for (int i = 0; i <= 10; i++) {
            Tracker3StaticFinalField.getInstance().add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getName(), is("3name"));
        assertThat(Tracker3StaticFinalField.getInstance().findAll().length, is(11));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getCreate(), is(99L));
        String idd = Tracker3StaticFinalField.getInstance().getItems()[i].getId();
        boolean result = Tracker3StaticFinalField.getInstance().replace("123123", new Item("newname", "newdesc", 98L));
        assertThat(result, is(false));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getName(), is("3name"));
        assertThat(Tracker3StaticFinalField.getInstance().findAll().length, is(11));
        assertThat(Tracker3StaticFinalField.getInstance().getItems()[i].getCreate(), is(99L));
        for (Item a : Tracker3StaticFinalField.getInstance().findAll()) {
            Tracker3StaticFinalField.getInstance().delete(a.getId());
        }
    }
}
