package org.lesson_25_Factory;

public class Plane implements Transport {

    @Override
    public void move() {
        System.out.println("Plane flies.");
    }
}
