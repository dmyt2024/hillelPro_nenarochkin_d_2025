package org.HomeWork_less_13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {
    private final Lock lock = new ReentrantLock();

    public synchronized int modify(int num) {
        lock.lock();
        try {
            num = num * 3;
            return num;
        } finally {
            lock.unlock();
        }
    }
}
