package org.grantharper.example.search;

public class BinarySearch {
    public static int locate(int[] arr, int target) {

        return binarySearch(arr, target, 0, arr.length - 1);
    }

    //given a sorted array, find a particular number that is input
    static int binarySearch(int[] arr, int target, int low, int high) {

        if (low == high) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (target < arr[middle]) {
            //search left side
            return binarySearch(arr, target, low, middle - 1);
        } else if (target > arr[middle]) {
            //search right side
            return binarySearch(arr, target, middle + 1, high);
        } else {
            return middle;
        }

    }


}
