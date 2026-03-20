package Binary;

import java.util.Arrays;

public class searchInsertIndex {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        Arrays.sort(nums);
        System.out.println(searchInsertplace(nums, 5, 0, nums.length - 1));
        System.out.println(searchInsertplace1(nums, 2));
    }

    public static int searchInsertplace(int[] nums,int target,int left,int right){
        // 思想错误1:混淆了递归和循环迭代的方式
        if(left > right)return left;
        int mid = (left + right) / 2;
        
        if (nums[mid] < target) {
            return searchInsertplace(nums, target, mid + 1, right);
        } else {
            return searchInsertplace(nums, target, left, mid - 1);
        }
    }

    public static int searchInsertplace1(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        // 编码错误1:left和right表示的应该是数组的下标而不是值
        while(left <= right){
            // 编码错误3:如果没有相等的话就那么left==right的场景就没有办法进入这个循环，没有办法进行检验(跟target比不可以漏数字，因此必须要等号)
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
                // 编码错误2:如果right = mid;就没有办法处理
            }else{
                return mid;
            }
        }
        return left;
    }
}
