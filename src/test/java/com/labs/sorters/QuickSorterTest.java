package com.labs.sorters;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 04.12.16.
 */
public class QuickSorterTest extends ArraySorterTest{

    private ArraySorter quickSorter;

    @Before
    public void setUp() throws Exception {
        quickSorter = new QuickSorter();
    }

    @Test
    public void sortArray() throws Exception {
        super.sortArray(quickSorter);
    }

    @Test
    public void checkArrayLength() {
        super.checkArrayLength(quickSorter);
    }

    @Test
    public void checkElements() {
        super.checkElements(quickSorter);
    }

}