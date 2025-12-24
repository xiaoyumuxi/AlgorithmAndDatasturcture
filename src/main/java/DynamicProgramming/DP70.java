package DynamicProgramming;

public class DP70 {
    public static void main(String[] args) {
        climbStairs(2);
        climbStairs(3);
        climbStairs(5);
    }

    public static void climbStairs(int n) {
        if (n <= 2) System.out.print(n);
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
            System.out.printf("%d->", dp[2]);
        }
        System.out.println();
    }
}
