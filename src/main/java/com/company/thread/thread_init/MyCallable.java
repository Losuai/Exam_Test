package com.company.thread.thread_init;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "I implement Callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(myCallable);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
