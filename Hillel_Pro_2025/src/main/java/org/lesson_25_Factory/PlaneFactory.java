package org.lesson_25_Factory;

public class PlaneFactory extends TransportFactory {

    @Override
    Transport createTransport() {
        return new Plane();
    }
}
