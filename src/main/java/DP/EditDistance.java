package DP;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minOperation("horse", "ros"));
    }

    public static int minOperation(String word1,String word2){
        int s1 = word1.length(),s2 = word2.length();
        int[][] dp = new int[s1+1][s2+1];
        // dp[i][j]表示word1的前i个元素和word2的前j个元素的转换需要的步骤数

        for (int i = 0; i <= s1; i++) dp[i][0] = i;
        for (int j = 0; j <= s2; j++) dp[0][j] = j;
        // 编码错误1:需要额外的初始化逻辑，初始化不是固定的是需要根据题目来不断思考的，不是都是0
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                        Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[s1][s2];
    }
}
