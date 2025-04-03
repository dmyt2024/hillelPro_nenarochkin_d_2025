package org.lesson_25_Factory;

public class CarFactory extends TransportFactory {

    @Override
    Transport createTransport() {
        return new Car();
    }
}
