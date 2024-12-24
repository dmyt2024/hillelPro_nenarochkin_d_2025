package org.lesson_1;

public class Main {
    public static final double CONV_K = 2.20462;
    public static void main(String[] args) {
        System.out.println("Converter App.");

        double kgs = 5;
        double pounds = convKgToPounds(kgs);
        System.out.println("Result is " + pounds + " pounds.");
    }
    private static double convKgToPounds(double kgs){
        return kgs*CONV_K;
    }
}