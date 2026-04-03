package DP;

public class maxSquare {
    public static void main(String[] args) {
        char[][] matirx = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maxS(matirx));
    }

    public static int maxS(char[][] matrix){
        int m = matrix.length,n = matrix[0].length;
        // dp[i][j] 表示(i,j)左上方的最大的正方形的边长
        int[][] dp = new int[m][n];
        int maxSize = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }   
        return maxSize*maxSize;
    }
}
