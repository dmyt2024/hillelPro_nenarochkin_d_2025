package org.lesson_2;

public class Main {
    public static final double CONV_M=1.60934;
    public static final double CONV_KM=0.621371;

    public static void main(String[] args) {
        System.out.println("Converter distance.");
        double mile=15;
        double km=convMileToKm(mile);
        System.out.println("Result is "+ km +" km.");


    }
    public static double convMileToKm(double mile){
        return mile*CONV_M;
    }
}
