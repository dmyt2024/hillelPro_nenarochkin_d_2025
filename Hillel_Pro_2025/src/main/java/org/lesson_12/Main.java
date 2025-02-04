package org.lesson_12;

public class Main {
    public static void main(String[] args) {

        DataHandler dataHandler = new DataHandler();
        MyThread myThread1 = new MyThread("Thread1", dataHandler);
        MyThread myThread2 = new MyThread("Thread2", dataHandler);
        myThread1.start();
        myThread2.start();
    }
}
