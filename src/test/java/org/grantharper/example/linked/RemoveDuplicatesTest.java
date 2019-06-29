package org.grantharper.example.linked;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RemoveDuplicatesTest {

    @Test
    public void shouldRemoveDuplicates() {
        LinkedList<String> list = new LinkedList<>();
        list.add("lame");
        list.add("sauce");
        list.add("world");
        list.add("cup");
        list.add("lame");
        list.add("cup");
        list.add("lame");

        RemoveDuplicates.removeDuplicates(list);

        assertThat(list.size()).isEqualTo(4);
    }
}