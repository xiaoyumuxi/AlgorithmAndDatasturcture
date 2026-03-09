package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class color {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(sort(nums)));
        sc.close();
    }

    public static int[] sort(int[] nums){
        int i = 0;//表示0和1的边界
        int j = nums.length-1;//表示1和2的边界
        int curr = 0;
        while(curr <= j){
            // 思路:刚开始默认0和2的区域大小为0,然后使用curr扫描的过程再swap和增大对应区域的面积(i++,j--)
            if(nums[curr] == 0){
                swap(nums, i, curr);
                i++;
                curr++;
            }else if(nums[curr] == 2){
                swap(nums, curr, j);
                j--;
                // 编码错误2:因为curr是从左边开始扫描的，因此左边的是已知的，但是右边是为止的因此必须要重新进行判断一下才可以
                // 因此这里就curr就不可以++了
            }else{
                curr++;
                // 编码错误1:扫到1的情况curr也需要++，这个忘记了就会导致没有反应
            }
        }
        return nums;
    }

    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
