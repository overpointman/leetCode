import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-24 11:05
 * @description:
 **/
public class BTree<k extends Comparable<k>, v> {
    // 阶
    private int order;

    // 根节点
    private BTNode<k, v> root;

    public BTree(int order) {
        this.order = order;
        this.root = null;
    }

    public void put(k key) {
        if (root == null) {
        }
    }

    static class BTNode<k extends Comparable<k>, v> {
        private int number = 0;

        private List<entry<k, v>> entries = new ArrayList<>();

        private List<BTNode<k, v>> children = new ArrayList<>();
    }

    static class entry<k extends Comparable<k>, v> {

    }
}
