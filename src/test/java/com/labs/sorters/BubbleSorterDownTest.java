package com.labs.sorters;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 04.12.16.
 */
public class BubbleSorterDownTest extends ArraySorterTest{

    private ArraySorter bubbleSorterDown;

    @Before
    public void setUp() throws Exception {
        bubbleSorterDown = new BubbleSorterDown();
    }

    @Test
    public void sortArray() throws Exception {
        super.sortArray(bubbleSorterDown);
    }

    @Test
    public void checkArrayLength() {
        super.checkArrayLength(bubbleSorterDown);
    }

    @Test
    public void checkElements() {
        super.checkElements(bubbleSorterDown);
    }

}