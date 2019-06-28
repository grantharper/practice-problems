package org.grantharper.example.general;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaRandom {

    //method to return an arbitrary subset from a list
    static List<Integer> getRandomSubject(List<Integer> list) {
        Random random = new Random(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        return list.stream().filter(
                integer -> random.nextBoolean()).collect(Collectors.toList());
    }

}
