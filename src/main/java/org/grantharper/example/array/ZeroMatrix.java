package org.grantharper.example.array;

public class ZeroMatrix {

    //accepts MxN matrix and if one element of a row is 0, mark all as 0

    public static void zeroMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    setRowToZero(arr[i]);
                    break;
                }
            }
        }
    }

    static void setRowToZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
