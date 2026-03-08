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
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(fast != slow){
            slow = nums[slow];           // 走一步
            fast = nums[nums[fast]];     // 走两步
        }

        // 相遇之后重置一个节点
        slow = nums[0];

        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;//这个时候再相遇就是在一个重复的环的入口处了，也就是重复的数
    }
}
