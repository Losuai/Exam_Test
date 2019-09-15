package com.company.thread.executor;

import com.company.thread.thread_init.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        for(int i=0; i<5; i++){
//            executorService.execute(new MyRunnable());
//        }
//        executorService.shutdown();
//        executorService.execute(() -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println("Thread1 run");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.shutdownNow();
//        System.out.println("Main run");

//        Future<?> ft = executorService.submit(()->{
//            try {
//                Thread.sleep(2000);
//                System.out.println("Thread2 run");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        ft.cancel(true);
        Main m1 = new Main();
        Main m2 = new Main();
//        executorService.execute(m1::func1);
//        executorService.execute(m2::func1);

        System.out.println("Main run");

        executorService.execute(()->  m1.func1());
        executorService.execute(()->  m2.func1());
    }
    public void func1(){
        synchronized (Main.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
    public static synchronized void func2(){
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
    }
}
