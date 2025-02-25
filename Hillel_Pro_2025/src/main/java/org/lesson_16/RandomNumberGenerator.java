package org.lesson_16;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int min, int max) {

        if (min < 0 || max > 100)
            throw new ArithmeticException("Wrong number");

        Random random = new Random();
        return random.nextInt(min, max + 1);

    }
}
