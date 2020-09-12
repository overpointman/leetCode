import java.util.Arrays;

/**
 * @author: alangong
 * @create: 2020-09-12 12:20
 * @description:
 **/
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        boolean[][] dp = new boolean[4][4];
        System.out.println(Arrays.toString(dp[1]));
    }
}
