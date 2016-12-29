package com.labs.sorters;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 04.12.16.
 */
public class InsertionSorterTest extends ArraySorterTest{

    private ArraySorter insertionSorter;

    @Before
    public void setUp() throws Exception {
        insertionSorter = new InsertionSorter();
    }

    @Test
    public void sortArray() throws Exception {
        super.sortArray(insertionSorter);
    }

    @Test
    public void checkArrayLength() {
        super.checkArrayLength(insertionSorter);
    }

    @Test
    public void checkElements() {
        super.checkElements(insertionSorter);
    }
}