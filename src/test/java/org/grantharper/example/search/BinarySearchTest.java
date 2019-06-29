package org.grantharper.example.search;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class BinarySearchTest {


    @Test
    public void shouldLocateElement() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = BinarySearch.locate(arr, 2);

        assertThat(index).isEqualTo(1);
    }

    @Test
    public void locateNonExistentElement() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = BinarySearch.locate(arr, 10);

        assertThat(index).isEqualTo(-1);
    }

    @Test
    public void searchLargeArray() {
        int[] ints = IntStream.iterate(1, i -> i + 1).limit(100_000_000L).toArray();
        int index = BinarySearch.locate(ints, 3);

        assertThat(index).isEqualTo(2);

    }
}