package DynamicProgramming;


//斐波拉契数列的动态规划
public class DP509 {
    public static void main(String[] args) {
        fib(2);
        fib(3);
        fib(4);
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
            System.out.printf("%d ", dp[1]);
        }
        System.out.println();
        return dp[1];
    }
}
