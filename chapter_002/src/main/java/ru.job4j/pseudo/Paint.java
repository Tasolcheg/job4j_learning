package ru.job4j.pseudo;

public class Paint {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Square square = new Square();
        System.out.println(triangle.draw());
        System.out.println(square.draw());
    }

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}