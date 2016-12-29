package com.labs.sorters;

/**
 * Sorts an array of integers with a merge sort algorithm
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class MergeSorter extends ArraySorter {

    /**
     * Sorts an array of integers with a merge sort algorithm
     * @param array array of integers
     * @see #mergeSort(int[], int, int)
     */
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Divides a part of array from low index to high index into two parts, sorts and merges it
     * @param array array to be sorted
     * @param low left bound of array
     * @param high right bound of array
     */
    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    /**
     * Merges two parts of array into sorted part of array
     * @param array array to be sorted
     * @param low left bound of array
     * @param middle middle of array
     * @param high right bound of array
     */
    private void merge(int[] array, int low, int middle, int high) {
        int[] temp = new int[array.length];
        System.arraycopy(array, low, temp, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }
    }
}
