import com.sun.scenario.effect.Brightpass;

/**
 * @author: alangong
 * @create: 2020-08-17 19:49
 * @description:
 **/
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }
}
