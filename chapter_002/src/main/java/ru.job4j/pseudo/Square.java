package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("#######");
        sb.append("#     #");
        sb.append("#     #");
        sb.append("#######");
        return sb.toString();
    }
}