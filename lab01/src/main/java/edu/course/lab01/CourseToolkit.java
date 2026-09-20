package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int divisor = 2;
        while (divisor * divisor <= number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor += 1;
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(right) != str.charAt(left)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    public static double average(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        long sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        return (double) sum / numbers.length;
    }

    public static int min(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        int minValue = values[0];
        for (int value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public static int max(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        int maxValue = values[0];
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
