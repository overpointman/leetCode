import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-14 00:57
 * @description:
 **/
public class GenerateParenthesis {
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        dfs(sb, n - 1, n);
        return ans;
    }

    // leftNum表示（的剩余个数,rightNum表示右括号的剩余个数
    private void dfs(StringBuilder sb, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            ans.add(sb.toString());
            return;
        }
        if (leftNum < rightNum && leftNum != 0) {
            dfs(sb.append('('), leftNum - 1, rightNum);
            sb.deleteCharAt(sb.length() - 1);
            dfs(sb.append(')'), leftNum, rightNum - 1);
            sb.deleteCharAt(sb.length() - 1);
        } else if (leftNum == 0){
            dfs(sb.append(')'), leftNum, rightNum - 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            dfs(sb.append('('), leftNum - 1, rightNum);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
