import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-09-12 23:16
 * @description:
 **/
public class TotalNQueens {
    private int count = 0;
    public int totalNQueens(int n) {
        // 纵向是否OK
        boolean[] column = new boolean[n];
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(matrix, n, n, column, ans, 0);
        return count;
    }

    // 行优先选择
    private void dfs(char[][] matrix, int times, int n, boolean[] column,
                     List<List<String>> ans, int a) {
        if (times == 0) {
            count++;
        }
        for (int j = 0; j < n; j++) {
            if (!column[j] && isMatch(matrix, a, j, n)) {
                column[j] = true;
                matrix[a][j] = 'Q';
                dfs(matrix, times - 1, n, column, ans, a + 1);
                matrix[a][j] = '.';
                column[j] = false;
            }
        }
    }

    // 构造结果
    private List<String> getRes(char[][] matrix) {
        List<String> list = new ArrayList<>();
        for (char[] cs : matrix) {
            list.add(String.valueOf(cs));
        }
        return list;
    }

    // 斜线是否OK
    private boolean isMatch(char[][] matrix, int i, int j, int n) {
        int min1 = Math.min(i, j);
        int a = i - min1, b = j - min1;
        while (a < n && b < n) {
            if (matrix[a][b] == 'Q') return false;
            a++;
            b++;
        }
        int min2 = Math.min(n - 1 - i, j);
        int c = i + min2, d = j - min2;
        while (c >= 0 && d < n) {
            if (matrix[c][d] == 'Q') return false;
            c--;
            d++;
        }
        return true;
    }
}
