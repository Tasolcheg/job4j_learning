package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {

            try {
                value = super.ask(question, range);
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
