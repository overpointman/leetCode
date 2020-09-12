import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-09-12 23:36
 * @description:
 **/
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        spiralOrder(ans, matrix, 0, 0, matrix.length, matrix[0].length);
        return ans;
    }

    private void spiralOrder(List<Integer> ans, int[][] matrix, int x, int y, int m, int n) {
        if (m <= 0 || n <= 0) return;
        // 1
        for (int i = y; i < y + n; i++) {
            ans.add(matrix[x][i]);
        }
        // 2
        for (int i = x + 1; i < x + m; i++) {
            ans.add(matrix[i][y + n - 1]);
        }
        // 3
        if (m != 1) {
            for (int i = y + n - 2; i >= y; i--) {
                ans.add(matrix[x + m - 1][i]);
            }
        }
        // 4
        if (n != 1) {
            for (int i = x + m - 2; i > x; i--) {
                ans.add(matrix[i][y]);
            }
        }
        spiralOrder(ans, matrix, x + 1, y + 1, m - 2, n - 2);
    }
}
