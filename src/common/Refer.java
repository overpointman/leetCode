import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author: alangong
 * @create: 2020-08-18 21:35
 * @description:
 **/
public class Refer {
    public static void main(String[] args) {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = "abc";// 强引用
        SoftReference<String> softRef = new SoftReference<>(str, referenceQueue);// 软引用
        WeakReference<String> weakRef = new WeakReference<>(str);// 弱引用
        // 创建虚引用，要求必须与一个引用队列关联
        PhantomReference<String> pr = new PhantomReference<>(str, referenceQueue);
        if (softRef.get() == null) return;
    }
}
