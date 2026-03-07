package Others;

import java.util.Scanner;

public class DiffPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] dp = new int[m][n];

            if (m <= 0 || n <= 0) return;

            // 初始化部分
            for (int i = 0; i < m; i++) dp[i][0] = 1;
            for (int j = 0; j < n; j++) dp[0][j] = 1;

            // 动态规划部分
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            System.out.println(dp[m - 1][n - 1]);
        } catch (Exception e) {
        } finally {
            scanner.close();
        }
    }
}
