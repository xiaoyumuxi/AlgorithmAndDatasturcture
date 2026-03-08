package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class nextArrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(getNext(nums)));
        sc.close();
    }

    public static int[] getNext(int[] nums){
        int breakPoint = find(nums);
        if(breakPoint != -1){
            swap(nums, breakPoint);
            reverse(nums, breakPoint + 1, nums.length - 1);
            // 编码错误3:只需要翻转breakPoint右侧的数组
        }else{
            reverse(nums, 0, nums.length - 1);
        }
        // 如果breakPoint是-1就跳过swap直接进行翻转整个数组
        
        return nums;
    }

    public static int find(int[] nums){
        // 不会的地方1:找到逆向的转折点
        for(int i = nums.length - 1 ; i > 0 ;i--){
            // 编码错误1:这里有nums[i-1]因此需要保证i>0
            if (nums[i] > nums[i - 1]){
                return i - 1;
            }
        }
        return -1;//否则就表示没有断点
    }

    public static void swap(int[] nums,int breakPoint){
        // 将断点和右侧部分的大于breakPoint的最小值进行交换
        int i = breakPoint;
        // 编码错误2:对于breakPoint是-1的情况没有进行单独的处理
        int j = nums.length - 1;
            // 在右边找到第一个比 nums[i] 大的数
        while (j >= breakPoint && nums[j] <= nums[i]) {
            j--;
        }
        // 然后就进行交换操作
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static boolean swap(int[] nums,int i,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return true;
    }

    public static void reverse(int[] nums,int i,int j){
        // 将nums数组从i到j进行翻转一下
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
