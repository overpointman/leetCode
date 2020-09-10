import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-23 18:57
 * @description:
 **/
public class HeapOOM {
    public static void main(String[] args) {
        while (true) {
            ByteBuffer.allocateDirect(1024 * 1024 * 5);
        }
    }
}
