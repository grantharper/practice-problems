package org.grantharper.example.sort;

public class SortedMerge {

    //a has enough buffer to hold b
    //a and b are both already sorted, merge b into a
    public static int[] sortedMerge(int[] a, int[] b) {
        //just implement the end of the merge sort
        int[] helper = new int[a.length + b.length];
        int aCount = 0;
        int bCount = 0;
        int helperCount = 0;
        while (aCount < a.length && bCount < b.length) {
            if (b[bCount] < a[aCount]) {
                helper[helperCount] = b[bCount];
                bCount++;
            } else {
                helper[helperCount] = a[aCount];
                aCount++;
            }
            helperCount++;
        }

        //copy remaining elements from either a or b when one is larger than the other
        while (aCount < a.length && helperCount < helper.length) {
            helper[helperCount] = a[aCount];
            aCount++;
            helperCount++;
        }

        while (bCount < b.length && helperCount < helper.length) {
            helper[helperCount] = b[bCount];
            bCount++;
            helperCount++;
        }


        return helper;
    }

    static void combineTheTwoArrays(int[] a, int[] b) {
        int j = b.length - 1;
        for (int i = a.length - 1; i > a.length - 1 - b.length; i--) {
            a[i] = b[j];
            j--;
        }
    }

}
