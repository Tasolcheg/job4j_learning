package ru.job4j.profession;

public class Engineer extends Profession {
    String name;

    public Engineer(String name, String profession, String name1) {
        super(name, profession);
        this.name = name1;
    }

    public House build(House house) {
        return house;
    }
}
