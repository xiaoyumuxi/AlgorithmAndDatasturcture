package DP;

public class LPS {
    public static void main(String[] args) {
        System.out.println(maxLen("abcde", "abc"));
    }

    public static int maxLen(String text1,String text2){
        int l1 = text1.length(),l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        // 编码错误1:定义dp语义的时候到底是表示index还是表示前i个字符一定需要注意对应关系，一般初始化的逻辑不太一样
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1))dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
