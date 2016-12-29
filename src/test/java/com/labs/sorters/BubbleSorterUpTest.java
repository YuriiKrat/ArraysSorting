package com.labs.sorters;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 04.12.16.
 */
public class BubbleSorterUpTest extends ArraySorterTest{

    private ArraySorter bubbleSorterUp;

    @Before
    public void setUp() throws Exception {
        bubbleSorterUp = new BubbleSorterUp();
    }

    @Test
    public void sortArray() throws Exception {
        super.sortArray(bubbleSorterUp);
    }

    @Test
    public void checkArrayLength() {
        super.checkArrayLength(bubbleSorterUp);
    }

    @Test
    public void checkElements() {
        super.checkElements(bubbleSorterUp);
    }

}