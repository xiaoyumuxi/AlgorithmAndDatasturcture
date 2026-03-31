package DP;

import java.util.Arrays;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(minNumOfPerfectSquare(12));
    }

    public static int minNumOfPerfectSquare(int n){
        // 和为n的完全平方数的最少数量
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for(int i = 1 ; i <= n;i++){
            // 编码错误2:这个dp数组有效值就是从1开始的，否则也会导致出现越界
            for (int j = 1; j*j <= i; j++) {
                // 编码错误1:这里是需要从1开始的到i截止，主要是防止下面的式子越界
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
