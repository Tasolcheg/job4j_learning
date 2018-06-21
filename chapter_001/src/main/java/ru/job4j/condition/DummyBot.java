package ru.job4j.condition;

/**
 * @author or Kretov Alexandr (mailto:no mail)
 * @version $Id$
 * @since 0.1
 */

public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
