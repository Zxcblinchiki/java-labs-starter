package edu.course.lab03;

public class PriceCalculator {
    private final DiscountPolicy policy;


    public PriceCalculator(DiscountPolicy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Discount policy cannot be null");
        }
        this.policy = policy;
    }

    public double calculate(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative");
        }
        return policy.apply(price);
    }
}