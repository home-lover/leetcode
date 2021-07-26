package threadpool_1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Date 2021/6/1 11:48 上午
 * @Author Tanjinhong
 */
public class submit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable callable = new Runnable() {
            @Override
            public void run(){
                System.out.println("This is ThreadPoolExetor#submit(Callable<T> task) method.");
                //return "result";
            }
        };

        ExecutorService executor  = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        Future future = executor.submit(callable);
        System.out.println(future.get());
    }
}
