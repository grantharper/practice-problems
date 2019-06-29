package org.grantharper.example.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueChars {


    public static boolean allCharsUnique(String str) {

        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (characterSet.contains(c)) {
                return false;
            } else {
                characterSet.add(c);
            }
        }

        return true;
    }
}
