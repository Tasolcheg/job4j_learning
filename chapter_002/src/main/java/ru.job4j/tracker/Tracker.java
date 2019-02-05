package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Рандомогенератор)
     */
    private static final Random RN = new Random();

    public Item[] getItems() {
        return items;
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод возвращает весь массив без null
     *
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Заменяет заявку сохраняя id
     *
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int inde = this.getIndex(id);
        if (inde != -1) {
            item.setId(this.items[inde].getId());
            this.items[inde] = item;
            result = true;
        }
        return result;
    }

    /**
     * Удаление Item из массива по id
     *
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        int ind = this.getIndex(id);
        if (ind != -1) {
            System.arraycopy(items, ind + 1, items, ind, this.items.length - ind - 1);
            position--;
            result = true;
        }
        return result;
    }

    /**
     * Метод создает массив с совпадениями по указанному имени
     *
     * @param name
     * @return Itemss массив совпадающих Item
     */
    public Item[] findByName(String name) {
        int ind = 0;
        Item[] itemTemp = new Item[100];
        for (Item a : items) {
            if (a != null && a.getName().equals(name)) {
                itemTemp[ind++] = a;
            }
        }
        Item[] itemss = Arrays.copyOf(itemTemp, ind);
        return itemss;
    }

    /**
     * Найти Item в массиве по id
     *
     * @param id
     * @return Возвращает Item
     */
    public Item findById(String id) {
        int index = getIndex(id);
        Item result = null;
        if (index != -1) {
            result = this.items[index];
        }
        return result;
    }

    /**
     * Узнать index по id
     *
     * @param id
     * @return index
     */
    public int getIndex(String id) {
        int result = -1;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
