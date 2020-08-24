import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-23 18:57
 * @description:
 **/
public class HeapOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }
}
