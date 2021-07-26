package jishuqixianliu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Date 2021/6/1 11:09 上午
 * @Author Tanjinhong
 */
public class AtomicInterServiceTask implements Runnable{
    //当前计数
    private volatile static AtomicInteger count = new AtomicInteger(0);
    //当前任务名字
    private String serviceName;
    //窗口内限流大小
    private int limit;

    AtomicInterServiceTask(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + serviceName + " is working!");
            System.out.println("当前线程：" + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + serviceName + " is over!");
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

    public boolean tryGet() {
        int newCount = count.addAndGet(1);
        if(newCount > 5) {
            System.out.println("请求用户过多，请稍后再试！");
            return false;
        }
        return true;
    }


}
