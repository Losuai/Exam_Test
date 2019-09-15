package com.company.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private Lock lock = new ReentrantLock();
    public void func1(){
        lock.lock();
        for (int i=0; i<5; i++){
            System.out.println("i: "+ i);
        }
        lock.unlock();

    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(lockExample::func1);
        executorService.execute(lockExample::func1);
    }
}
