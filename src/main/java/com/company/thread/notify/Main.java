package com.company.thread.notify;

public class Main {
    private static final Object obj = new Object();

    public static void main(String[] args) {
        Thread[] rs = new Thread[10];
        for(int i = 0;i < 10;i++) {
            rs[i] = new Thread(new R(i));
        }
        for(Thread r : rs) {
            r.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(obj) {
            System.out.println("notifyAll");
            obj.notifyAll();
        }
    }

    static class R implements Runnable {
        int i;

        R(int i) {
            this.i = i;
        }

        public void run() {
            try {
                synchronized(obj) {
                    System.out.println("线程->  " + i + " 等待中");
                    obj.wait();
                    System.out.println("线程->  " + i + " 在运行了");
                    Thread.sleep(3000);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
