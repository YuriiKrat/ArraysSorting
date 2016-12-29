package com.labs.fillers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 04.12.16.
 */
public class ArrayFactoryTest {

    private int length = 100;

    @Test
    public void checkSortedArray() {
        int[] array = ArrayFactory.createSortedArray(length);
        for(int i = 0; i < array.length - 1; i++) {
            Assert.assertFalse(array[i] > array[i + 1]);
        }
    }

    @Test
    public void checkInvertedSortedArray() {
        int[] array = ArrayFactory.createInvertedSortedArray(length);
        for(int i = array.length - 1; i > 0; i--) {
            Assert.assertFalse(array[i] > array[i - 1]);
        }
    }

    @Test
    public void checkSortedArrayWithRand() {
        int[] array = ArrayFactory.createSortedArrayWithRand(length);
        for(int i = 0; i < array.length - 2; i++) {
            Assert.assertFalse(array[i] > array[i + 1]);
        }
    }



}