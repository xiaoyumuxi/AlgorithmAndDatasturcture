package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeNumSUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        } 
        System.out.println(ThreeNum(nums));
        sc.close();
    }

    public static List<List<Integer>>  ThreeNum(int[] nums){
        // 默认隐性规定i < j < k
        List<List<Integer>> res = new ArrayList<>();
        // 思路错误1:虽然知道是双指针法但是还是不小心写成了暴力三层循环的方式，而且缺乏去重的思路，双指针的前提是有序数组

        Arrays.sort(nums);
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] > 0)break;
            int j = i + 1,k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue; 
            // 编码错误1:在下面的while里面对j和k进行了去重但是外面没有对i进行去重因此就导致出现了重复结果
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0)k--;
                else if(sum < 0)j++;
                else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 思路错误2:因为即使定好了得出了一个之后还是可以继续下去的，因此j和k还是要移动的，但是这里需要去重
                    while(j < k && nums[j] == nums[j+1])j++;
                    while(j < k && nums[k] == nums[k-1])k--;// 跳过相同元素
                    j++;k--;//继续找其他的可能性
                }
            }
        }
        return res;
    }
}
