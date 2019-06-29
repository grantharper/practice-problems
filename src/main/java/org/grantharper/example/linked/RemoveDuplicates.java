package org.grantharper.example.linked;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDuplicates {

    public static void removeDuplicates(LinkedList<String> list) {

        Set<String> temp = new HashSet<>();
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();
            if (temp.contains(value)) {
                iterator.remove();
            } else {
                temp.add(value);
            }
        }


    }

}
