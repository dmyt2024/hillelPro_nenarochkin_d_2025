package org.lesson_25_Factory;

public class Main {
    public static void main(String[] args) {

        Client client = new Client();
        Transport transport = client.run("plane");
        transport.move();
    }
}
