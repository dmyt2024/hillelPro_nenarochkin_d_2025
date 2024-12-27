package org.lesson_3;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Converter temperature.");

        int celsius = 50;
        int far = convCelsToFarkengate(celsius);
        System.out.println("Farkengate temperature is " + far + " degrees.");

    }

    public static int convCelsToFarkengate(int celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
