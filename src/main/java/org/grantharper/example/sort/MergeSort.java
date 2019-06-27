package org.grantharper.example.sort;

public class MergeSort {

    public static void sort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] helper, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, helper, left, middle);
            mergeSort(arr, helper, middle + 1, right);
            merge(arr, helper, left, middle, right);
        }
    }

    static void merge(int[] arr, int[] helper, int left, int middle, int right) {
        //copy both halves into a helper array
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = left;
        int helperRight = middle + 1;
        int current = left;
        while(helperLeft <= middle && helperRight <= right) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }

    private static int[] copy(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

}
