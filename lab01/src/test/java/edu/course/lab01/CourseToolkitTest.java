package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @Test
    void returnTrueForPrimeNumber() {
        boolean result = CourseToolkit.isPrime(7);
        assertTrue(result);
    }

    @Test
    void returnsFalseForCompositeNumber() {
        boolean result2 = CourseToolkit.isPrime(8);
        assertFalse(result2);
    }

    @Test
    void returnTrueForTwo() {
        boolean result2 = CourseToolkit.isPrime(2);
        assertTrue(result2);
    }

    @Test
    void returnsFalseForSquareOfPrime() {
        boolean result3 = CourseToolkit.isPrime(49);
        assertFalse(result3);
    }

    @Test
    void returnTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("шалаш");
        assertTrue(result);
    }

    @Test
    void returnTrueForAntiPalindrome() {
        boolean result2 = CourseToolkit.isPalindrome("Машква");
        assertFalse(result2);
    }

    @Test
    void throwsExceptionForNullPalindrome() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    @Test
    void returnsCorrectAverageForPositiveNumbers() {
        double result = CourseToolkit.average(new int[]{2, 4, 6});
        assertEquals(4.0, result);
    }

    @Test
    void throwsExceptionForEmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[]{}));
    }

    @Test
    void returnsCorrectAverageForNegativeNumbers() {
        double result = CourseToolkit.average(new int[]{-2, -4, -6});
        assertEquals(-4.0, result);
    }

    @Test
    void returnsMinimumValue() {
        int result = CourseToolkit.min(new int[]{5, 2, 8, 1, 4});
        assertEquals(1, result);
    }

    @Test
    void returnsMaximumValue() {
        int result = CourseToolkit.max(new int[]{5, 2, 8, 1, 4});
        assertEquals(8, result);
    }

    @Test
    void throwsExceptionForEmptyArrayInMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(new int[]{}));
    }

    @Test
    void throwsExceptionForEmptyArrayInMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(new int[]{}));
    }
}