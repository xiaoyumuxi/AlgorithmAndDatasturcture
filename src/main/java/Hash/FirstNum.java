package Hash;

import java.util.Arrays;

public class FirstNum {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] <= n && nums[i] >=1 && nums[nums[i] - 1] != nums[i] ) {// 限制为正数
                // nums[nums[i] - 1] == nums[i]表示下标对应位置住的已经有一样的了，那么就不需要再进行交换了
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }// 思路错误1:触发不断的检验和交换从而保证两个nums[i]上一定是i+1，非法的数组-1等不会被交换但是会被后面的合法的部分交换到最后面去
            // 最后前面一部分区域是有序的，后面是重复的还有不在合法区间里面的
        }
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                res = i + 1;
                break;
            }
        }
        return res == -1 ? n + 1 : res;

    }
}
