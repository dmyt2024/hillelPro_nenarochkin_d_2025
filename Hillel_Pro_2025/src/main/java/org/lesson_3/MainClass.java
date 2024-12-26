package org.lesson_3;

public class MainClass {
    public static final int FAR = 32;

    public static void main(String[] args) {
        System.out.println("Converter temperature.");

        int cel = 50;
        int far = convCelsToFarkengate(cel);
        System.out.println("Farkengate temperature is " + far + " degrees.");

    }

    public static int convCelsToFarkengate(int cel) {
        return (cel * 9 / 5) + 32;
    }
}
