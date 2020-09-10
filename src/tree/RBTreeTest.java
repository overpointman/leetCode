/**
 * @author: alangong
 * @create: 2020-08-24 22:14
 * @description:
 **/
public class RBTreeTest {
    public static void main(String[] args) {
        RBTree<Integer, String> rbTree = new RBTree<>();
        rbTree.put(5, "5");
        rbTree.put(7, "7");
        rbTree.put(6, "6");
        rbTree.put(8, "8");
        rbTree.put(3, "3");
        rbTree.put(1, "1");
        rbTree.put(13, "13");
        rbTree.put(17, "17");
        System.out.println(rbTree.get(8));
        System.out.println(rbTree.get(7));
        System.out.println(rbTree.get(6));
        System.out.println(rbTree.get(5));
        System.out.println(rbTree.get(13));
        System.out.println(rbTree.get(17));
    }
}
