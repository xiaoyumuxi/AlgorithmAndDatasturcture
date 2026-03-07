package Others;

import java.util.Arrays;

public class coins {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(coinsNum(coins, 11));
    }

    public static int coinsNum(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        int max = amount + 1; // 定义一个逻辑上的“无穷大”

        Arrays.fill(dp, max); // 将所有金额初始化为“无法凑齐”
        dp[0] = 0;
        //最少硬币数就是先尽可能的使用最大的coins
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
