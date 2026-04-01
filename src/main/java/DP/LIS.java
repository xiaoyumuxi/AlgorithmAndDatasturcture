package DP;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LIS {
    public static void main(String[] args) {
        int[] n = {10,9,2,5,3,7,101,18};
        System.out.println(MaxLen1(n));
    }

    // 最长递增子序列
    public static int MaxLen(int[] nums){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);
        int max = 0;
        for(int i = 0 ; i < nums.length ;i++){
            if(!stack.isEmpty() && stack.peek() >= nums[i]){
                // 将所有大于nums[i]的元素弹出
                while(!stack.isEmpty() && stack.peek() >= nums[i])stack.pop();
                stack.push(nums[i]);
            }else{
                stack.push(nums[i]);
            }
            max = Math.max(max, stack.size());
        }
        return max;
    }// 只能对一部分的用例，主要是[2,4,6,8,5,9]这种里面实际上最长是[2,4,5,8,9]但是因为我弹出了8和9,最后导致这里面8后续没有被利用到

    public static int MaxLen1(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 编码错误1:这里刚开始所有的都起码有一个自己，这个是基础的长度是不需要遍历更新的，因此这个初始化特别容易出错
        int max = 1;
        for(int i = 1; i < n ;i++){
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]); 
            // 编码错误2:这个表示以i结尾的最大的链长度是多少，但是这个以什么结尾和最大没有关系，因此需要全局更新
        }
        return max;
    }
}
