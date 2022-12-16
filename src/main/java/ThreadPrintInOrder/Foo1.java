package ThreadPrintInOrder;

import java.util.concurrent.Semaphore;

public class Foo1 {

    public Foo1() {

    }

    Semaphore semaphore1 = new Semaphore(0);
    Semaphore semaphore2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public interface Foo1Method {
        void call(Runnable printFirst) throws InterruptedException;
    }
    private static void call(Foo1Method method, String text) {
        try {
            method.call(() -> System.out.print(text));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Foo1 foo1 = new Foo1();
        Thread t1 = new Thread(() -> call(foo1::first, "first"));
        Thread t2 = new Thread(() -> call(foo1::second, "second"));
        Thread t3 = new Thread(() -> call(foo1::third, "third"));

        t2.start();
        t3.start();
        t1.start();

    }
}

