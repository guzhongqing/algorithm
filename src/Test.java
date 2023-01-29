import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        sellTicket sellTicket = new sellTicket();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sellTicket.sell();
            }
        }, "售票员1").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sellTicket.sell();
            }
        }, "售票员2").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sellTicket.sell();
            }
        }, "售票员3").start();
    }
}

class sellTicket {
    private int tickets = 100;//同一个对象，线程共享
    private final Lock reentrantLock = new ReentrantLock();

    public synchronized void sell() {
        reentrantLock.lock();//手动上锁
        try {
            if (tickets > 0) System.out.println(Thread.currentThread().getName() + "售出一张票,剩余" + --tickets + "张票");
        } finally {
            reentrantLock.unlock();//手动解锁
        }
    }
}