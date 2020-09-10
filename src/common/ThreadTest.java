import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: alangong
 * @create: 2020-08-31 21:27
 * @description:
 **/
public class ThreadTest {
    private volatile static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (i > 100) {
                    System.out.println(i);
                    Thread.currentThread().interrupt();
                } else {
                    i++;
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
}
