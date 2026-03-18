package Hash;

import java.util.HashMap;
import java.util.Map;

public class MostfulElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
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
}
