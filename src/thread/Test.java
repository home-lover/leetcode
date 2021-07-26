package thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/1 5:39 下午
 * @Author Tanjinhong
 */
public class Test {
    public static void main(String[] args) {
        //实现runnable 创建三个线程
        RunnableTest r = new RunnableTest();
        for(int i = 0; i < 3; i++) {
            Thread thread = new Thread(r);
            thread.start();
        }

        //动态代理
        final List<String> list = new ArrayList<String>();
        List<String> proxyInstance =
                (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                        list.getClass().getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                return method.invoke(list, args);
                            }
                        });
        proxyInstance.add("你好");
        System.out.println(list);
    }
}
