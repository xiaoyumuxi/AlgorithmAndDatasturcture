package DP;

public class ClimbStep {
    public static void main(String[] args) {
        System.out.println(Climb(5));
        System.out.println(dp(5));
        System.out.println(dp1(5));
    }

    public static int Climb(int n){
        dfs(n, 0);
        return nums;
    }

    public static int nums = 0;

    // 明明可以使用DFS来进行解析的，为什么使用DP？
    public static void dfs(int n,int curSum){
        if(curSum == n)nums++;
        if(curSum > n)return;

        dfs(n, curSum+1);
        dfs(n, curSum+2);
    }

    // 这个也不是DP，这个是递归法，因为还是有重复子问题的反复计算
    public static int dp(int n){
        if(n < 2)return 1;
        if(n == 2)return 2;
        return dp(n-1) + dp(n-2);
    }

    // 这个才是最常见的DP的解法，是需要从最开始的地方一步步算上去的，和DFS是一样的，而上面的递归则是从结果直接获取出来的
    public static int dp1(int n){
        if(n < 2)return 1;
        if(n == 2)return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
