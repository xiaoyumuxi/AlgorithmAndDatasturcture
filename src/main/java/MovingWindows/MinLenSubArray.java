package MovingWindows;

import java.util.Scanner;

public class MinLenSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n ;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(minSubArrayLen(target, nums));
        sc.close();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0,j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            if(sum >= target){
                // 如果大于了，首先尝试更新len
                len = Math.min(len,j - i + 1);
                // 然后开始尝试收缩一下看看可不可以拿到更小长度的
                while(sum >= target){
                    len = Math.min(len,j - i + 1);
                    sum-=nums[i];
                    i++;
                }
            }
            j++;
            // 编码错误1:仅仅条件j++，这样会导致滑动窗口没有滑动完整个数组从而导致漏解的情况的
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
