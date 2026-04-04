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
        // 编码错误1:这是必须是最大值的，否则的话就是就会导致出错的，主要是dp方程里面全是最小值，如果全是默认的就糟了，不会有状态变化了
        dp[0] = 0;
        for(int i = 0 ; i < coins.length ;i++){
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
            }
        }
        // 这个for循环是不一定的，需要根据不同的场景来，其实我感觉这个更合理
        // for (int i = 1; i < dp.length; i++) {
        //     for (int j = 0; j < coins.length; j++) {
        //         // 这里的i >= coins[j],因此就必须要至少大于coins里面的最小值1,因此就需要初始化dp[0]
        //         if(i >= coins[j]){
        //             dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
        //         }
        //     }
        // }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
