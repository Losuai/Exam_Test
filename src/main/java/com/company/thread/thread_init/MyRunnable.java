package com.company.thread.thread_init;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("I implements Runnable");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
