import java.lang.ref.*;

/**
 * @author: alangong
 * @create: 2020-08-18 15:56
 * @description:
 **/
public class Child extends Parent{
    private static String name;

    private static Child c;

    public static void A() {
        System.out.println("Child A");
    }

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, refQueue);
        // null
        System.out.println(phantomRef.get());
        // null
        System.out.println(refQueue.poll());
        obj = null;
        // 通知JVM的gc进行垃圾回收
        System.gc();
        System.gc();
        // null, 调用phantomRef.get()不管在什么情况下会一直返回null
        System.out.println(phantomRef.get());
        // 当GC发现了虚引用，GC会将phantomRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phantomRef对象，并没有被GC回收，在我们显式地调用refQueue.poll返回phantomRef之后
        // 当GC第二次发现虚引用，而此时JVM将phantomRef插入到refQueue会插入失败，此时GC才会对phantomRef对象进行回收
        Reference<?> pollObj = refQueue.poll();
        // java.lang.ref.PhantomReference@1540e19d
        System.out.println(pollObj);
        if (null != pollObj) {
            // 进行资源回收的操作
        }
    }
}
