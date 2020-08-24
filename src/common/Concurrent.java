import java.util.concurrent.CountDownLatch;

/**
 * @author: alangong
 * @create: 2020-08-24 09:45
 * @description:
 **/
public class Concurrent {
    private static volatile int count = 0;

    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        int n = 100000;
        final CountDownLatch countDown = new CountDownLatch(n);
        for (int i = 0; i < n; i++) {
            new Thread(() -> {count++; countDown.countDown();}).start();
        }
        countDown.await();
        System.out.println(countDown);
        System.out.println(count);
    }
}
