/**
 * @author: alangong
 * @create: 2020-09-12 19:33
 * @description:
 **/
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int times = n / 2;
        for (int i = 0; i < times; i++) {
            for (int j = i; j < n - i; j++) {
                int one = matrix[i][j];
                int two = matrix[j][n - 1 - i];
                int three = matrix[n - 1 - i][n - 1 - j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[j][n - 1 - i] = one;
                matrix[n - 1 - i][n - 1 - j] = two;
                matrix[n - 1 - j][i] = three;
            }
        }
    }
}
