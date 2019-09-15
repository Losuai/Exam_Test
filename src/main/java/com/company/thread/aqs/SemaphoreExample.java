package com.company.thread.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<totalRequestCount; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();//获取许可
                    System.out.println("Get:"+semaphore.availablePermits());
                    System.out.println("Not:"+semaphore.getQueueLength());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//归还许可
                }
            });
        }
        executorService.shutdown();
    }
}
