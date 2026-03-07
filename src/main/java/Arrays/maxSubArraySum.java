package Arrays;

import java.util.Scanner;

public class maxSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(getMaxSubArraySum(nums));
        sc.close();
    }

    public static int getMaxSubArraySum(int[] nums){
        int max = Integer.MIN_VALUE;
        // 编码错误2: 如果全是负数的数组就没有办法确保max是0,因此这里建议从nums[0]开始or从最小值开始
        int sum = 0;
        int j=0;
        while(j < nums.length){
            if(sum < 0)sum = 0;
            // 编码错误1: 小于0是需要进行重置的，这个不进行重置是错误的
            // 这里的i是没有任何用的，因为没有参与窗口的控制

            sum += nums[j];
            max = Math.max(sum,max);
            j++;
            
        }
        return max;
    }
    
}
