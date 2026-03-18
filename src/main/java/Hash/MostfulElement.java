package Hash;

import java.util.HashMap;
import java.util.Map;

public class MostfulElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(MostfulElements(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > n / 2)res = key;
            // 思路错误1:题目要求的是返回多数元素是那个元素而不是频率
        }
        return res;
    }

    public static int MostfulElements(int[] nums){
        // 但是上面的方法没有达到O(1)的空间复杂度，因此这里用的是摩尔投票法->Boyer-Moore Voting Algorithm
        int candidate = nums[0];
        int count = 0;// 这个结构是模仿哈希表的，是必须要的

        for(int num : nums){
            if(count == 0){
                candidate = num; // 这个时候就擂主死了就换人
            }
            if(num == candidate)count++;
            else count--;
        }

        return candidate;
    }
}
