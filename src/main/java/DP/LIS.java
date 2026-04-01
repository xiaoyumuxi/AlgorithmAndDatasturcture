package DP;

import java.util.ArrayDeque;
import java.util.Deque;

public class LIS {
    public static void main(String[] args) {
        int[] n = {10,9,2,5,3,7,101,18};
        System.out.println(MaxLen(n));
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
}
