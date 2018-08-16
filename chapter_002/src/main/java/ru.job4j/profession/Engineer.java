package ru.job4j.profession;

public class Inginer extends Profession {
    String name;

    public Inginer(String name) {
        this.name = name;
    }

    public House build(House house) {
        return house;
    }
}
