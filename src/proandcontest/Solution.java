package proandcontest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Date 2021/6/14 1:31 下午
 * @Author Tanjinhong
 */
public class Solution {
    private static Queue<Integer> queue = new LinkedList<>();
    private static final int capacity = 5;
    private static int i = 0;
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            new Produce();
        },"pro3").start();
        Thread pro1 = new Thread(new Produce());
        Thread pro2 = new Thread(new Produce());
        Thread con1 = new Thread(new Consume());
        Thread con2 = new Thread(new Consume());
        pro1.start();
        pro2.start();
        con1.start();
        con2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop();
    }

    public static class Produce implements Runnable {

        @Override
        public void run() {
            while(flag) {
                synchronized(queue) {
                    while(queue.size() == capacity) {
                        try {
                            System.out.println("queue is full");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "--produce: " + i);
                    queue.offer(i++);
                    queue.notifyAll();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Consume implements Runnable {

        @Override
        public void run() {
            while(flag) {
                synchronized(queue) {
                    while(queue.isEmpty()) {
                        try {
                            System.out.println("queue is empty");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int x = queue.poll();
                    System.out.println(Thread.currentThread().getName() + "--consume: " + x);
                    queue.notifyAll();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void stop() {
        flag = false;
    }

}
