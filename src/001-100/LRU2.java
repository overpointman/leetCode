import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: alangong
 * @create: 2020-08-13 16:30
 * @description: 继承LinkedHashMap
 **/
public class LRU2<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    LRU2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRU2 cache = new LRU2(10);
    }
}
