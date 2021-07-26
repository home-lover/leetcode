package jishuqixianliu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Date 2021/6/1 4:25 下午
 * @Author Tanjinhong
 */
public class Simple {
    private AtomicInteger count = new AtomicInteger(0);
    private int limit = 100;

    public void hello() {
        count.incrementAndGet();
        if(count.get() > limit) {
            System.out.println("达到限制了！");
            return;
        }
        try {
            System.out.println("正常处理！" + count.get());
        }finally {
            count.decrementAndGet();
        }
    }
}
