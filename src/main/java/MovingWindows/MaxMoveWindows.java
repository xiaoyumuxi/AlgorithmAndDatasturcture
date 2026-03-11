package MovingWindows;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MaxMoveWindows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n ;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        sc.close();
    }
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 构建一个存Index的单调队列
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while(!queue.isEmpty() && queue.peekFirst() <= i - k)queue.pollFirst();//将过期的弹出去

            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])queue.pollLast();
            //当前新来的元素 nums[i]，会把队尾所有比它小的元素全部淘汰掉
            // 思路错误1:单调递减的单调队列，每一次入一个元素都会导致队尾后面的比其小的元素被淘汰的
            
            queue.offerLast(i);

            if (i >= k - 1) {
                ans[idx++] = nums[queue.peekFirst()];
            }

        }

        return ans;

    }
}
