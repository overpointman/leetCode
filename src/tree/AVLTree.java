/**
 * @author: alangong
 * @create: 2020-08-18 10:32
 * 平衡二叉树构建
 **/
public class AVLTree<T extends Comparable<T>> {
    private AVLTreeNode<T> root;    // 根结点

    // AVL树的节点(内部类)
    static class AVLTreeNode<T extends Comparable<T>> {
        T key;                // 键值
        int height;         // 高度
        AVLTreeNode<T> left;    // 左孩子
        AVLTreeNode<T> right;    // 右孩子

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /*
     * 获取树的高度
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(root);
    }

    /*
     * LL：左左对应的情况(左单旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private AVLTreeNode<T> ll(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2 = k1.left;

        k1.left = k2.right;
        k2.right = k1;
        k1.height = Math.max(k1.left.height + 1, k1.right.height + 1);
        k2.height = Math.max(k2.left.height + 1, k2.right.height + 1);

        return k2;
    }

    /*
     * RR：右右对应的情况(右单旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private AVLTreeNode<T> rr(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(k1.left.height + 1, k1.right.height + 1);
        k2.height = Math.max(k2.left.height + 1, k2.right.height + 1);
        return k2;
    }

    /*
     * LR：左右对应的情况(左双旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private AVLTreeNode<T> lr(AVLTreeNode<T> k1) {
        k1.left = rr(k1.left);

        return ll(k1);
    }

    /*
     * RL：右左对应的情况(右双旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private AVLTreeNode<T> rl(AVLTreeNode<T> k1) {
        k1.right = ll(k1.right);

        return rr(k1);
    }

    /*
     * 将结点插入到AVL树中，并返回根节点
     *
     * 参数说明：
     *     tree AVL树的根结点
     *     key 插入的结点的键值
     * 返回值：
     *     根节点
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            // 新建节点
            tree = new AVLTreeNode<T>(key, null, null);
        } else {
            int cmp = key.compareTo(tree.key);

            if (cmp < 0) {    // 应该将key插入到"tree的左子树"的情况
                tree.left = insert(tree.left, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0)
                        tree = ll(tree);
                    else
                        tree = lr(tree);
                }
            } else if (cmp > 0) {    // 应该将key插入到"tree的右子树"的情况
                tree.right = insert(tree.right, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0)
                        tree = rr(tree);
                    else
                        tree = rl(tree);
                }
            } else {    // cmp==0
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }

        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    public void insert(T key) {
        root = insert(root, key);
    }
}
