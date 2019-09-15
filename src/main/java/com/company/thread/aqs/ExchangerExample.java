package com.company.thread.aqs;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> {
            String A = "I A";
            try {
                String B = exchanger.exchange(A);
                System.out.println("t1:"+B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()-> {
            String B = "I B";
            try {
                String A = exchanger.exchange(B);
                System.out.println(A.equals(B));
                System.out.println(A);
                System.out.println(B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
