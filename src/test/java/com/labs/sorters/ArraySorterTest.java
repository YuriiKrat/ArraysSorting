package com.labs.sorters;

import org.junit.Assert;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 04.12.16.
 */
public class ArraySorterTest {

    public void sortArray(ArraySorter instance) throws Exception {
        int[] array = new int[] {10, 6, 4, 6, 9, 4, 8, 0, 1, 7};
        instance.sort(array);
        for(int i = 0; i < array.length - 1; i++) {
            Assert.assertFalse(array[i] > array[i + 1]);
        }
    }

    public void checkArrayLength(ArraySorter instance) {
        int[] array = new int[] {10, 6, 4, 6, 9, 4, 8, 0, 1, 7};
        int length = 10;
        instance.sort(array);
        Assert.assertTrue(array.length == length);
    }

    public void checkElements(ArraySorter instance) {
        int[] beginArray = new int[] {10, 6, 4, 6, 9, 4, 8, 0, 1, 7};
        int[] array = new int[10];
        System.arraycopy(beginArray, 0, array, 0, 10);
        instance.sort(array);
        for(int i = 0; i < beginArray.length; i++) {
            boolean contains = false;
            for (int j = 0; j < array.length; j++) {
                if (beginArray[i] == array[j]) {
                    contains = true;
                }
            }
            Assert.assertFalse(!contains);
        }
    }

}