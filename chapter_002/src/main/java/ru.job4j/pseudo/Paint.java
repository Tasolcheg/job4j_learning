package ru.job4j.pseudo;

public class Paint {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        System.out.println(triangle.draw());
        System.out.println(square.draw());
    }

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}