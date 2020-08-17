import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: alangong
 * @create: 2020-08-17 21:18
 * 中序遍历
 **/
public class InOder {
    public static void traversal(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            // 压入该节点和左子树
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode cur = stack.pop();
                visit(cur);
                if (cur.right != null) {
                    p = cur.right;
                }
            }
        }
    }

    public static void visit(TreeNode root) {
        System.out.println(root.val);
    }
}
