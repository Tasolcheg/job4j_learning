package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.

        ArrayDuplicate sorter = new ArrayDuplicate();
        String[] input = new String[]{"Привет", "Мир", "Привет", "Супер", "Мир", "Собака"};
        String[] result = sorter.stringsort(input);
        String[] expect = new String[] {"Привет", "Мир", "Супер", "Собака"};
        assertThat(result, Matchers.is(expect));
    }
}

