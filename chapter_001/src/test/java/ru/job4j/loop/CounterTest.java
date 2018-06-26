package ru.job4j.loop;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    /**
     * @author or Kretov Alexandr (mailto:no mail)
     * @version $Id$
     * @since 0.1
     */
    @Test
    public void counterTest() {
        Counter maxim = new Counter();
        int result = maxim.counter(3, 21);
        assertThat(result, is(108));
    }
}