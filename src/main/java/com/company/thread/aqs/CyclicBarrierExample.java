package com.company.thread.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<totalThread; i++){
             executorService.execute(() -> {
                 System.out.println("before..");
                 try {
                     //用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
                     cyclicBarrier.await();
                 } catch (InterruptedException | BrokenBarrierException e) {
                     e.printStackTrace();
                 }
                 System.out.println("after..");

             });
        }
        executorService.shutdown();
    }
}
