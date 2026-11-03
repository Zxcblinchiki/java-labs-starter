package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercentDiscountTest {
    @Test 
    public void test1() {
        PercentDiscount policy = new PercentDiscount(20);
        assertEquals(80, policy.apply(100.0), 0.0001);
    }
    @Test
    public void test2() {
        PercentDiscount policy = new PercentDiscount(0);
        assertEquals(100, policy.apply(100.0), 0.0001);
    }
    @Test
    public void test3() {
        PercentDiscount policy = new PercentDiscount(100);
        assertEquals(  0, policy.apply(100.0), 0.0001);
    }
    @Test
    public void test4() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-1));;
    }
    @Test
    public void test5() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }
    @Test 
    public void test6() {
        PercentDiscount policy = new PercentDiscount(20);
        assertThrows(IllegalArgumentException.class, () -> policy.apply(-100));;
    }
}