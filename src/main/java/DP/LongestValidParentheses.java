package DP;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(maxParent1(")()())"));
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

    public static int maxParent1(String s){
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        //dp[i]表示从0...i的最长有效括号的长度
        if(n < 2)return 0;
        for(int i = 1;i < n;i++){
            if(s.charAt(i)=='(')continue;
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    // 因为这个i-1,因此循环从i=1开始的
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else{
                    int j = i-dp[i-1]-1;
                    if(j >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = dp[i-1] + 2;
                        // 这里加上dp[j-1]有值存在的问题，因此需要三元处理一下
                        dp[i] += (j >= 1 ? dp[j - 1] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

}
