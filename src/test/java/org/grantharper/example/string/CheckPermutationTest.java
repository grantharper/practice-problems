package org.grantharper.example.string;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class CheckPermutationTest {

    @Test
    public void isPermutation() {
        String str1 = "abc";
        String str2 = "bac";

        boolean permutation = CheckPermutation.isPermutation(str1, str2);
        assertThat(permutation).isTrue();

    }

    @Test
    public void largerPermutation() {
        String str1 = "aaaabbbccccccd";
        String str2 = "abbaaabcdccccc";

        boolean permutation = CheckPermutation.isPermutation(str1, str2);
        assertThat(permutation).isTrue();

    }

    @Test
    public void shouldGenerateCharacterCountMap() {
        String str = "aaabbbbc";

        Map<Character, Integer> countMap = CheckPermutation.characterCountMap(str);

        assertThat(countMap.keySet()).hasSize(3);
        assertThat(countMap.get('a')).isEqualTo(3);
        assertThat(countMap.get('b')).isEqualTo(4);
        assertThat(countMap.get('c')).isEqualTo(1);
    }
}