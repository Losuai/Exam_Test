package com.company.thread.thread_init;

public class MyThread extends Thread {
    static int index = 0;
    @Override
    public void run() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (this) {
//            System.out.println(" Thread index: " + index);
//        }
        while (Thread.interrupted()){
            System.out.println("......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread end");
        }

    }

    public static void main(String[] args) {
//        for (int i=0; i<5; i++){
//            index=i;
//            MyThread thread = new MyThread();
//            if (i == 2) {
//                Thread.yield();
//                System.out.println("Thread.yield()");
//                try {
//                    Thread.sleep(2000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            thread.start();
//        }
        Thread thread1 = new MyThread();
//        Thread thread2 = new MyThread();
        thread1.start();
//        通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，
//        那么就会抛出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
        thread1.interrupt();
//        thread2.start();

        System.out.println("Main run");
    }
}
