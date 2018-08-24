package ru.job4j.tracker;

public class Item {
    private String id;

    public String name;

    public String description;

    public Long create;

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public void setId(String id) {
        this.id = id;
    }
}
