package ait.multi.task;

import ait.multi.MyTaskExtends;
import ait.multi.MyTaskImplements;

public class MultithreadingAppl {
    private static final int MAX = 10;
    private static final int SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        Runnable task1 = new MyTaskImplements("TaskImplements", MAX);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new MyTaskExtends("TaskExtends", MAX);
        Runnable[] tasks = new Runnable[SIZE];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new MyTaskImplements("Name # " + i, MAX);
        }
        Thread[] threads = new Thread[tasks.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tasks[i]);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        thread1.start();
        thread2.start();
        for (int i = 0; i < MAX; i++) {
            System.out.println("Main thread, count = " +i);
            Thread.sleep(1);
        }
        thread1.join();
        thread2.join();
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Main thread finished");
    }
}
