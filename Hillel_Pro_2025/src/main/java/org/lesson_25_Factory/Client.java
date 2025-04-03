package org.lesson_25_Factory;

public class Client {

    public Transport run(String transportType) {
        if (transportType.equalsIgnoreCase("car")) {
            TransportFactory carFactory = new CarFactory();
            return carFactory.createTransport();
        } else if (transportType.equalsIgnoreCase("plane")) {
            TransportFactory planeFactory = new PlaneFactory();
            return planeFactory.createTransport();
        } else {
            throw new RuntimeException("Transport type not recognized");
        }
    }
}
