package com.labs.sorters;

/**
 * Sorts an array of integers with a insertion sort algorithm
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class InsertionSorter extends ArraySorter {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    /**
     * Swaps two elements in array
     * @param array array
     * @param i index of the first element to be swapped
     * @param j index of the second element to be swapped
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
