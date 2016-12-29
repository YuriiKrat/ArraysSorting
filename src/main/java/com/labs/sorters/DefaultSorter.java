package com.labs.sorters;

import java.util.Arrays;

/**
 * Sorts array by default method
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class DefaultSorter extends ArraySorter {

    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
