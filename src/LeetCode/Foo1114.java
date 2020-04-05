package LeetCode;

public class Foo1114 {
    Object lock = new Object();
    boolean firstfinished = false;
    boolean secondfinished = false;

    public Foo1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            printFirst.run();
            firstfinished = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock) {
            while (firstfinished == false)
                lock.wait();
            printSecond.run();
            secondfinished = true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (firstfinished == false || secondfinished == false)
                lock.wait();
            printThird.run();
        }

    }
}
