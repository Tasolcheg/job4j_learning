package ru.jobj.tracker;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void trackerItemAddTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "desc", 99L));
        assertThat(tracker.getItems()[0].getName(), is("name"));
        assertThat(tracker.getItems()[0].getDescription(), is("desc"));
    }


    @Test
    public void trackerfindByNameTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1name", "1desc", 99L));
        tracker.add(new Item("1name", "2desc", 99L));
        tracker.add(new Item("2name", "3desc", 99L));
        tracker.add(new Item("1name", "4desc", 99L));
        tracker.add(new Item("2name", "5desc", 99L));
        for (Item a : tracker.findByName("1name")) {
            assertThat(a.getName(), is("1name"));
        }
        for (Item a : tracker.findByName("2name")) {
            assertThat(a.getName(), is("2name"));
        }
    }

    @Test
    public void trackerfindByIdTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "desc", 99L));
        assertThat(tracker.findById(tracker.findByName("name")[0].getId()).getDescription(), is("desc"));
    }

    @Test
    public void trackerfindAllTest() {
        Tracker tracker = new Tracker();
        int i = 0;
        for (int x = 0; x <= 50; x++) {
            tracker.add(new Item(x + "name", x + "desc", 99L));
        }
        for (Item a : tracker.findAll()) {
            assertThat(a.getName(), is(i + "name"));
            assertThat(a.getDescription(), is(i++ + "desc"));
        }
        assertThat(tracker.findAll().length, is(i));
    }

    @Test
    public void trackerDeleteTest() {
        Tracker tracker = new Tracker();
        for (int x = 0; x <= 10; x++) {
            tracker.add(new Item(x + "name", x + "desc", 99L)); // создаем заявки
        }
        assertThat(tracker.getItems()[2].getName(), is("2name")); // до удаления
        tracker.delete(tracker.getItems()[2].getId());                  //удаление
        assertThat(tracker.getItems()[2].getName(), is("3name")); //после удаления
        assertThat(tracker.getItems().length, is(100)); //проверяем длинну (она имеет значение)
    }

    @Test
    public void trackerReplaceTest() {
        Tracker tracker = new Tracker();
        for (int i = 0; i <= 10; i++) {
            tracker.add(new Item(i + "name", i + "desc", 99L));
        }
        int i = 3;
        assertThat(tracker.getItems()[i].getName(), is("3name"));
        assertThat(tracker.findAll().length, is(11));
        assertThat(tracker.getItems()[i].getCreate(), is(99L));
        String idd = tracker.getItems()[i].getId();
        tracker.replace(tracker.getItems()[i].getId(), new Item("newname", "newdesc", 98L));
        assertThat(tracker.getItems()[i].getName(), is("newname"));
        assertThat(tracker.findAll().length, is(11));
        assertThat(tracker.getItems()[i].getId(), is(idd));
        assertThat(tracker.getItems()[i].getCreate(), is(98L));
    }
}
