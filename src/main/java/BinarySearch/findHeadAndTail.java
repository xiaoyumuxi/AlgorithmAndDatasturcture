package BinarySearch;

import java.util.Arrays;

public class findHeadAndTail {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(find(nums, 8)));
    }

    public static int[] find(int[] nums,int target){
        return new int[]{leftfind(nums, target),rightfind(nums, target)};
    }

    public static int leftfind(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                // 思路错误1:找到target==num[mid]后不可以停止，需要继续进行递归
                right = mid - 1;
            }
        }
        return left;
    }


    public static int rightfind(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                // 和上面的错误是一样的，这里不可以提前返回还需要不断的向右找
                left = mid + 1;
            }
        }
        return right;
    }
}
