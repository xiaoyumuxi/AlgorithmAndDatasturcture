package DynamicProgramming;

public class DP746 {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        minCostClimbingStairs(cost);
    }
    public static void minCostClimbingStairs(int[] cost) {
        if (cost.length <= 2) {
            System.out.print(Math.min(cost[0], cost[1]));
        }
        int[] dp = new int[ 2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int minCost = Math.min(dp[1] + cost[i - 1], dp[0] + cost[i - 2]);
            dp[0] = dp[1];
            dp[1] = minCost;
        }
        System.out.println(dp[1]);
    }
}
