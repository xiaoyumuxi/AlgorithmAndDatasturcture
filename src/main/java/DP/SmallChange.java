package DP;

import java.util.Arrays;

public class SmallChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(minCoins(coins, 11));
    }

    public static int minCoins(int[] coins,int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        // 编码错误1:这是必须是最大值的，否则的话就是就会导致出错的
        dp[0] = 0;
        for(int i = 0 ; i < coins.length ;i++){
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
