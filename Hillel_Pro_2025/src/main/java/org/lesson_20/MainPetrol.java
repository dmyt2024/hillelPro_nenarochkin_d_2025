package org.lesson_20;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MainPetrol {
    public static void main(String[] args) throws InterruptedException {
        PetrolStation petrolStation = new PetrolStation(100);

        IntStream.rangeClosed(1, 10).mapToObj(i -> new Thread(() ->  {
            petrolStation.doRefuel(refuelValue());})).forEach(Thread::start);
    }

    private static Integer refuelValue() {
        int min = 5;
        int max = 20;
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
