package com.mihadev.poderevjanskyibot.play;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] initialArray = {100,6, 10, 1, 3, 5, 7, 25};
        MergeSort.mergeSort(initialArray);

        int[] expected = new int[]{1, 3, 5, 6, 7, 10, 25, 100};

        Assert.assertArrayEquals(expected, initialArray);
    }
}