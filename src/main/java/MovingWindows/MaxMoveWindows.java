package MovingWindows;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class MaxMoveWindows {
    public static void main(String[] args) {
        
    }
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] max = new int[nums.length - k + 1];//max里面存的只最大值的索引
        int MaxNum = Integer.MIN_VALUE;
        for(int i = 0 ; i < k ; i++){
            if(nums[i] > MaxNum){
                MaxNum = nums[i];
                max[0] = i;
            }
            map.put(i, nums[i]);
        }
        // 开始维护滑动的流程
        int i = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int j = k - 1 ; j < nums.length ; j++){
            map.put(j,nums[j]);//刚进来右边扩展
            map.remove(i);//左边需要缩小
            // 需要维护当前窗口的最大值
            if(max[i-1] >= i && max[i-1] <=j )max[i] = max[i-1];//保持不变
            if(max[i-1] < i){
                // 这个时候是需要进行处理的，感觉是需要一个堆结构的
            }
        }
    }
}
