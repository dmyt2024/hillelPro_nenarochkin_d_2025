package org.lesson_12;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

public class DataHandler {
    String[] fruits = new DataRepository().getData();

    public void getOutput() {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            AtomicInteger count = new AtomicInteger(1);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s", count.getAndIncrement(), fruit));

            }
            System.out.println(currentThread().getName() + ": " + sb);
        }
    }
}
