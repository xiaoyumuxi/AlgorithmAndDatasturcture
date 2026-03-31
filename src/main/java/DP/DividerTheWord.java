package DP;

import java.util.HashSet;
import java.util.Set;

public class DividerTheWord {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet","code"};
        System.out.println(canAppend(s, wordDict));
    }

    public static boolean canAppend(String s,String[] wordDict){
        int len = s.length();
        int[] lens = new int[wordDict.length];
        for (int i = 0; i < lens.length; i++) {
            lens[i] = wordDict[i].length();
        }
        // lens里面需要凑出来一个和是len的数，可以重复->完全背包
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        // 思路错误1:dp[i]表示的是第i个字符前面的部分是否匹配上
        for (int i = 1; i <= len; i++) {
            for(int j = 0 ; j < i ;j++){
                // 编码错误1:这里表示的[0...j-1]和[0..i-1]，从j到i-1求substring使用左闭右开就是(j,i)
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
