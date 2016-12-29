package com.labs.sorters;

/**
 * Sorts an array with bubble sort algorithm passing elements up
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class BubbleSorterUp extends ArraySorter {

    @Override
    public void sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
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
