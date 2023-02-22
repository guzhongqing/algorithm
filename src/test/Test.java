package test;

import java.util.concurrent.TimeUnit;

class Test {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                System.out.println("持有锁a，视图获取锁b");
                //JUC包中的sleep，先让t1获得锁a，t2获得锁b
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("获取锁b");
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println("持有锁b，视图获取锁a");
                //JUC包中的sleep调用Thread.sleep()1秒，先让t1获得锁a，t2获得锁b
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("获取锁a");
                }
            }
        }, "t2").start();
    }
}


//        Lock lock = new ReentrantLock();
//        new Thread(() -> {
//            try {
//                lock.lock();
//                System.out.println(Thread.currentThread().getName() + "外层");
//                lock.lock();
//                System.out.println(Thread.currentThread().getName() + "内层");
//            } finally {
//                lock.unlock();
//            }
//        }, "t1").start();
//
//        new Thread(() -> {
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "外层");
//        }, "t2").start();