package org.lesson_16;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        //       1
        MathOperation add = Integer::sum;
        System.out.println(add.operate(2, 6));

//       2
        StringManipulator toUpper = (str) -> str.toUpperCase();
        System.out.println(toUpper.manipulate("String line"));

//       3
        Function<String, Integer> uppLetters = StringListProcessor::countUppercase;
        System.out.println(uppLetters.apply("Upper LeTTers"));

//       4
        Supplier<Integer> supplier = () -> RandomNumberGenerator.generateRandomNumber(5, 20);
        System.out.println(supplier.get());

    }
}
