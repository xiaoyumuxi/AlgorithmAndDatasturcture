package Arrays;

import java.util.Scanner;

public class findTheSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(find(nums));
        System.out.println(find1(nums));
        sc.close();
    }
    
    public static int find(int[] nums){
        for(int i = 0; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] == nums[j])return nums[i];
            }
        }
        return -1;
    }// O(N^2)复杂度，有点高了需要进行优化

    public static int find1(int[] nums){
        // 使用双指针--快慢指针的方法来进行遍历,因为题目数据里面有nums[i] <= n
        int slow = 0,fast = 0;

        do{
            slow = nums[slow];           // 走一步
            fast = nums[nums[fast]];     // 走两步
        }while(fast != slow);
        // 编码错误2:最开始就是从0开始的，但是为了避免fast == slow因此需要使用do……while循环

        // 相遇之后重置一个节点
        slow = 0;
        // 编码错误1:应该是重置到最开始的起点位置去,最开始的位置错了不是nums[0]而是0

        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;//这个时候再相遇就是在一个重复的环的入口处了，也就是重复的数
    }
}
