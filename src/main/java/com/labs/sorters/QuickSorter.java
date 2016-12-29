package com.labs.sorters;

/**
 * Sorts an array of integers with a quick sort algorithm
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class QuickSorter extends ArraySorter {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Sorts a part of array from left index to right index
     * @param array array to be sorted
     * @param low left bound of array
     * @param high right bound of array
     */
    private void quickSort(int[] array, int low, int high) {
        int i  = low;
        int j = high;
        int pivot = array[low + (high - low)/2];
        while (i <= j) {
            while(array[i] < pivot){
                i++;
            }
            while(array[j] > pivot) {
                j--;
            }
            if(i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
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
