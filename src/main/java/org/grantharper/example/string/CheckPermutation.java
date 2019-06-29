package org.grantharper.example.string;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static boolean isPermutation(String str1, String str2) {
        //verify they are the same length
        if (str1.length() != str2.length()) {
            return false;
        }

        //put all chars of str1 in a hashmap with their count
        Map<Character, Integer> str1Map = characterCountMap(str1);

        //for all chars of str2, check whether they are in the str1 hashmap
        int matchCounter = 0;
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            //subtract the character counts from str1Map and add to the matchCounter
            if (!str1Map.containsKey(c)) {
                return false;
            } else {
                Integer currentCharCount = str1Map.get(c);
                if (currentCharCount < 1) {
                    return false;
                }
                str1Map.put(c, currentCharCount - 1);
                matchCounter++;
            }
        }

        return matchCounter == str1.length();
    }

    static Map<Character, Integer> characterCountMap(String str) {
        Map<Character, Integer> str1Map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            str1Map.compute(str.charAt(i), (k, v) -> {
                if(v == null){
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
        return str1Map;
    }

}
