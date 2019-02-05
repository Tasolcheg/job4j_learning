package ru.job4j.tracker;

public class ValidateInput implements Input {
    public final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {

            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный выбор пункта меню1");
            } catch (MenuOutException mfe) {
                System.out.println("Неверный выбор пункта меню2");
            }
        }
        while (invalid);
        return value;
    }
}
