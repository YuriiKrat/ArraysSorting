package com.labs.sorters;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 28.11.16.
 */
public class MergeSorterTest extends ArraySorterTest{

    private ArraySorter mergeSorter;

    @Before
    public void setUp() throws Exception {
        mergeSorter = new MergeSorter();
    }

    @Test
    public void sortArray() throws Exception {
        super.sortArray(mergeSorter);
    }

    @Test
    public void checkArrayLength() {
       super.checkArrayLength(mergeSorter);
    }

    @Test
    public void checkElements() {
        super.checkElements(mergeSorter);
    }
}
