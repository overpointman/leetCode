import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: alangong
 * @create: 2020-08-12 18:50
 * @description:手撸版
 **/
public class LRU1 {
    private static Map<String, Node> lruMap;

    private Node head, tail;

    private Integer maxSize;

    public static void main(String[] args) {
        LRU1 lruCatch = new LRU1(4);
        lruCatch.put("key1", "value1");
        lruCatch.put("key2", "value2");
        lruCatch.put("key3", "value3");
        lruCatch.put("key4", "value4");
        lruCatch.get("key1");
        lruCatch.put("key5", "value5");
        System.out.println(lruCatch.get("key1"));
    }

    private LRU1(int maxSize) {
        this.maxSize = maxSize;
        lruMap = new ConcurrentHashMap<>(maxSize * 4/3);
    }

    public synchronized void put(String key, String value) {
        if (lruMap.size() == 0) {
            init(key, value);
        } else if (lruMap.size() < maxSize) {
            this.addNode(key, value);
        } else {
            this.removeLast();
            this.addNode(key, value);
        }
    }

    public synchronized String get(String key) {
        if (lruMap.get(key) == null) {
            return null;
        } else {
            this.moveToHead(lruMap.get(key));
            return lruMap.get(key).value;
        }

    }

    private void addNode(String key, String value) {
        Node cur = new Node(value, key);
        cur.next = head;
        cur.pre = tail;
        head.pre = cur;
        tail.next = cur;
        head = cur;
        lruMap.put(key, cur);
    }

    private void init(String key, String value) {
        Node cur = new Node(key, value);
        head = cur;
        tail = cur;
        lruMap.put(key, cur);
    }

    private void removeLast() {
        lruMap.remove(tail.key);
        tail = tail.pre;
        tail.next = head;
        head.pre = tail;
    }

    private void moveToHead(Node node) {
        if (head == node) {
            return;
        }
        if (tail == node) {
            tail = tail.pre;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head;
        node.pre = tail;
        head.pre = node;
        tail.next = node;
    }

    static class Node {
        private Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        private String key;

        private String value;

        private Node next;

        private Node pre;
    }
}
