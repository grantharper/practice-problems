package org.grantharper.example.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class SortedMergeTest {

    private int[] a = {-5, -4, -3, -2, -1};
    private int[] b = {-7, -6, -5};

    @Test
    public void combineArraysTest() {
        SortedMerge.combineTheTwoArrays(a, b);
        assertThat(a[a.length - 1]).isEqualTo(-5);
        Arrays.stream(a).forEach(System.out::println);
    }

    @Test
    public void mergeSortedArrays() {
        int[] result = SortedMerge.sortedMerge(a, b);
        Arrays.stream(result).forEach(System.out::println);
        assertThat(result[result.length - 1]).isEqualTo(-1);

    }
}