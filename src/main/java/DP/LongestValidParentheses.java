package DP;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(maxParent("(()"));
    }

    public static int maxParent(String s){
        // dp[i][j]表示[i...j]之间是否是连续有效括号子串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        if(s.length()<2)return 0;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if(s.charAt(i)=='('&&s.charAt(j)==')')dp[i][j] = dp[i+1][j-1];
                if(s.charAt(j-1)=='('&&s.charAt(j)==')')dp[i][j] = dp[i][j-2];
                // 思路错误1:这里只能处理(())()这种情况，但是实际上我们的分割点是任意的，如果想用这种方式处理的话里面需要对分割点的可能性再来一个循环
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(dp[i][j]==true)max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
}
