package org.grantharper.example.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ZeroMatrixTest {

    @Test
    public void shouldZeroMatrix() {
        int[][] arr = {{1, 2, 3}, {2, 3, 0}, {1, 0, 2}};

        ZeroMatrix.zeroMatrix(arr);


        assertThat(arr[0][0]).isEqualTo(1);
        assertThat(arr[0][1]).isEqualTo(2);
        assertThat(arr[0][2]).isEqualTo(3);
        assertThat(arr[1][0]).isEqualTo(0);
        assertThat(arr[1][1]).isEqualTo(0);
        assertThat(arr[1][2]).isEqualTo(0);
        assertThat(arr[2][0]).isEqualTo(0);
        assertThat(arr[2][1]).isEqualTo(0);
        assertThat(arr[2][2]).isEqualTo(0);
    }
}