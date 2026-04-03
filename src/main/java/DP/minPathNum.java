package DP;

public class minPathNum {
    public static void main(String[] args) {
        System.out.println(pathNums(3, 7));
    }

    public static int pathNums(int m,int n){
        int[][] dp = new int[m][n];
        // 思路错误1:因为是路径是直接对应关系，不用处理空串的概念，因此直接开(m,n)即可
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // dp[i][j]表示的意思是从以前到(i,j)的路径条数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
