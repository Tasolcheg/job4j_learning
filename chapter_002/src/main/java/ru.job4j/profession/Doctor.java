package ru.job4j.profession;

public class Doctor extends Profession {

    public Diagnose heal(Patient pacient) {
        return null;
    }

    public Doctor(String name, String profession) {
        super(name, profession);
    }
}
