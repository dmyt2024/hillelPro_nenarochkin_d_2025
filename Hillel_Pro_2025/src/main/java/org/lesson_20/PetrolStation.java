package org.lesson_20;

import java.util.concurrent.LinkedBlockingQueue;

public class PetrolStation {
    private volatile int amount;
    LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public void doRefuel(int petrol) {
        try {
            queue.put(petrol);

            System.out.println(Thread.currentThread().getName() + " - Refuel start");
            Thread.sleep(3000);


            synchronized (this) {
                if (amount >= petrol) {
                    amount -= petrol;
                    System.out.println(Thread.currentThread().getName()
                            + " - Refuel finished. Petrol left: " + amount);
                } else {
                    System.out.println(Thread.currentThread().getName()
                            + " - Not enough petrol anymore");
                }
            }

            queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }
}
