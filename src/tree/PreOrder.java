import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: alangong
 * @create: 2020-08-17 21:17
 * 先序遍历
 **/
public class PreOrder {
    public static void traversal(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            visit(cur);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }

    public static void visit(TreeNode root) {
        System.out.println(root.val);
    }
}
