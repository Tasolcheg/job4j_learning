package ru.job4j.loop;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    /**
     * @author or Kretov Alexandr (mailto:no mail)
     * @version $Id$
     * @since 0.1
     */
    @Test
    public void factorialTest() {
        Factorial m = new Factorial();
        int result = m.factorial(10);
        assertThat(result, is(3628800));
    }
}
