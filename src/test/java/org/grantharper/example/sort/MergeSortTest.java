package org.grantharper.example.sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @Test
    public void shouldSortArray() {
        int[] arr = {2, 4, 1, 3, 5, 6, 7};

        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        MergeSort.sort(arr);

        for (int i = 0; i < expected.length; i++) {
            assertThat(arr[i]).isEqualTo(expected[i]);
        }
    }
}
