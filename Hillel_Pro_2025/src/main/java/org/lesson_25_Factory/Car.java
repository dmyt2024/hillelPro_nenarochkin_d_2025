package org.lesson_25_Factory;

public class Car implements Transport {
    @Override
    public void move() {
        System.out.println("Car drives");
    }
}
