package thread;

/**
 * @Description TODO
 * @Date 2021/6/1 5:39 下午
 * @Author Tanjinhong
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
