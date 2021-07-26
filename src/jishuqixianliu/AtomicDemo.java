package jishuqixianliu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Date 2021/6/1 3:37 下午
 * @Author Tanjinhong
 */
public class AtomicDemo {
    public static class TestLimit implements Runnable{
        private volatile static AtomicInteger count = new AtomicInteger(0);
        private int limit = 5;
        @Override
        public void run() {
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " is working");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + " is finished");
        }

        public boolean tryAcquire() {
            int newCount = count.addAndGet(1);
            if(newCount > limit) {
                System.out.println("被限流了！");
                return false;
            }

            //System.out.println("！");
            return true;
        }
    }

    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 100L, TimeUnit.SECONDS, new SynchronousQueue<>());
        int count = 0;
        for(int i = 0; i < 10; i++) {
            TestLimit testLimit = new TestLimit();
            if(testLimit.tryAcquire()) {
                executor.execute(testLimit);
                count++;
            }
        }

        System.out.println(count);
    }





//    public static void main(String[] args){
//        ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//        int count = 0;
//        for(int i = 0 ; i < 10 ; i++){
//            AtomicInterServiceTask serviceTask = new AtomicInterServiceTask("task" + i);
//            if(serviceTask.tryGet()) {
////                Thread thread = new Thread(serviceTask);
////                thread.start();
//                //方法二 用线程池
//                executor.submit(serviceTask);
//                count++;
//            }
//        }
//        System.out.println("count: " + count);
//
//    }

}
