package Others;

public class Distance {

    public static void main(String[] args) {
        String[] str = { "horse", "ros" };
        System.out.println(opreactor(str[0], str[1]));
    }

    public static int opreactor(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        //dp[i][j]表示s1前i个字符变成s2前j个字符的最少操作数

        //初始情况
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        //DP流程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //最后两个字符一样那么就直接继承即可
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] =
                        Math.min(
                            dp[i - 1][j - 1], //最后的字符不一样，替换即可
                            Math.min(
                                dp[i][j - 1], // 需要给s1插入一个字符
                                dp[i - 1][j] // 需要给s1删去一个元素
                            )
                        ) +
                        1;
                }
            }
        }
        return dp[m][n];
    }
}
