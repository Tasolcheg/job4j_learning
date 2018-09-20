package ru.jobj.pseudo;

import org.junit.Test;
import ru.job4j.pseudo.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexndr Kretov (mailto:mail@mail.mail)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   #   ")
                                .append("  # #  ")
                                .append(" #   # ")
                                .append("#######")
                                .toString()
                )
        );
    }
}