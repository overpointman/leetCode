import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: alangong
 * @create: 2020-08-12 18:39
 * @description:
 **/
public class RedisIncr {
    private static Map<String, AtomicInteger> keyMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(incr("test", 1));
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(keyMap.get("test"));
    }

    private static int incr(String key, int step) {
        if (keyMap.get(key) == null) {
            keyMap.putIfAbsent(key, new AtomicInteger(0));
        }
        return keyMap.get(key).addAndGet(step);
    }
}
