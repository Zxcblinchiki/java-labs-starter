package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NoDiscountTest {
    @Test
    public void test1() {
        NoDiscount policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0), 0.0001);
    }
    @Test
    public void test2() {
        NoDiscount policy = new NoDiscount();
        assertEquals(0.0, policy.apply(0.0), 0.0001);
    }
    @Test
    public void rejectsNegativePrice() {
        NoDiscount policy = new NoDiscount();

        assertThrows(IllegalArgumentException.class,
                () -> policy.apply(-100));
    }
}