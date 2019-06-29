package org.grantharper.example.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.grantharper.example.string.UniqueChars.allCharsUnique;

public class UniqueCharsTest {


    @Test
    public void shouldDetermineAllUniqueChars() {
        String str = "123456789";
        boolean areUnique = allCharsUnique(str);

        assertThat(areUnique).isTrue();

        String str1 = "hello";
        boolean areUnique1 = allCharsUnique(str1);

        assertThat(areUnique1).isFalse();
    }
}