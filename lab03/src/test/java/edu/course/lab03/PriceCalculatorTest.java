package edu.course.lab03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
    @Test 
    public void test1() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        double result = calculator.calculate(100.0);
        assertEquals(100.0, result, 0.0001);
    }
    @Test 
    public void test2() {
        PriceCalculator calculator = new PriceCalculator(new PercentDiscount(20));
        double result = calculator.calculate(100.0);
        assertEquals(80.0, result, 0.0001);
    }
    @Test 
    public void test3() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-1));
    }
    @Test 
    public void test4() {
        assertEquals(100.0, new PriceCalculator(new NoDiscount()).calculate(100.0), 0.0001);
        assertEquals(80.0, new PriceCalculator(new PercentDiscount(20)).calculate(100.0), 0.0001);
        assertEquals(0.0, new PriceCalculator(new AlwaysZeroDiscount()).calculate(100.0), 0.0001);
    }
    private static class AlwaysZeroDiscount implements DiscountPolicy {
        @Override
        public double apply(double price) {
            return 0.0;
        }
    }
}