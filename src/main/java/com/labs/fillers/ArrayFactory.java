package com.labs.fillers;

import com.labs.annotations.Filler;

/**
 * Factory for creating arrays of integers
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class ArrayFactory {

    /**
     * Maximal value in array with random values for
     * the first element
     */
    private static int MAX_RANGE = 1000;

    /**
     * Creates sorted array with defined length in inverse order
     *
     * @param length length of an array
     * @return array of integers
     */
    @Filler
    public static int[] createInvertedSortedArray(int length) {
        int[] array = new int[length];
        int lowBound = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = (int)(Math.random() * (MAX_RANGE) + lowBound);
            lowBound = array[i];
        }
        return array;
    }

    /**
     * Creates an array of random integers with max value {@link #MAX_RANGE}
     *
     * @param length length of an array
     * @return array of random integers
     */
    @Filler
    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * MAX_RANGE);
        }
        return array;
    }

    /**
     * Creates sorted array with defined length
     *
     * @param length length of an array
     * @return array of random integers
     */
    @Filler
    public static int[] createSortedArray(int length) {
        int[] array = new int[length];
        int lowBound = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * (MAX_RANGE) + lowBound);
            lowBound = array[i];
        }
        return array;
    }

    /**
     * Creates sorted array with defined length and random last element
     *
     * @param length length of an array
     * @return array of random integers
     */
    @Filler
    public static int[] createSortedArrayWithRand(int length) {
        int[] array = new int[length];
        int lowBound = 0;
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = (int)(Math.random() * (MAX_RANGE) + lowBound);
            lowBound = array[i];
        }
        array[array.length - 1] = (int)(Math.random() * MAX_RANGE);
        return array;
    }
}
