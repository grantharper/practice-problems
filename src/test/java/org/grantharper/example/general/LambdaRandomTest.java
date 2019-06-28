package org.grantharper.example.general;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LambdaRandomTest {

    @Test
    public void shouldSelectSublist() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
        List<Integer> randomSublist = LambdaRandom.getRandomSubject(list);

        System.out.println(randomSublist);
    }
}