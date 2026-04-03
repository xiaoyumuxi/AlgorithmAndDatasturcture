package DP;

public class RegularExprMatch {
    public static void main(String[] args) {
        System.out.println(re1("ab", ".*"));
    }

    public static boolean re(String s,String p){
        int j = 0;
        for (int i = 0 ; i < p.length(); i++) { // 这个是p匹配模式的指针
            if(p.charAt(i)=='.'){
                j++;
            }
            if(p.charAt(i)=='*'){
                // 开始进行匹配，但是这里到底匹配几个字符是需要思考的，不能固定下来，因此才会用到DP
                if(i > 0 && p.charAt(i-1)=='.')return true;
            }
            if(s.charAt(j)!=p.charAt(i))return false;
        }
        return true;
    }

    public static boolean re1(String s,String p){
        int a = s.length(),b = p.length();
        boolean[][] dp = new boolean[a+1][b+1];
        // dp[i][j]表示s前i个字符是否和p前j个字符匹配
        dp[0][0] = true;
        for (int j = 2; j <= b; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if(p.charAt(j-1)=='.'|| s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2]; // 匹配0次，直接跳过
                    if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                        // 思路错误1:这里是因为如果在当前已经有*匹配的情况下如果再出现了多次匹配的话，这里需要一个链式结构
                        // 匹配1+次：当前字符能被 x* 吃掉 → 吃一个，x* 保留，看剩下的
                    }
                }

            }
        }
        return dp[a][b];
    }
}
