package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        } 
        System.out.println(Arrays.toString(move(nums)));
        sc.close();
    }
    
    public static int[] move(int[] nums){
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[j]!=0){
                swap(nums, i, j);
                i++;
            } // 思路错误1:因为这里的i比j慢而j找到非0里面跟i进行了交换就确保了i前面的都是非0的数
            j++;
        }
        return nums;
    }

    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
