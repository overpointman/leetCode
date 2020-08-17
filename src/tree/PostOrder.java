import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: alangong
 * @create: 2020-08-17 21:19
 * 后序遍历
 **/
public class PostOrder {
    public static void traversal(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;  // 当前节点
        TreeNode q = null;  // 记录上一个访问的节点，如果新加入右子树，需要重置为null,否则死循环
        do {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                // 出栈时如果有右子树且没有访问过，重新入栈
                if (cur.right != q) {
                    stack.push(cur);
                    p = cur.right;
                    q = null;
                    break;
                } else {
                    visit(cur);
                    q = cur;
                }
            }
        } while (!stack.isEmpty());
    }

    public static void visit(TreeNode root) {
        System.out.println(root.val);
    }
}
