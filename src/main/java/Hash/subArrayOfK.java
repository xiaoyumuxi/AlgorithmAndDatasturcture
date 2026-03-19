package Hash;

import java.util.HashMap;
import java.util.Map;

public class subArrayOfK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }

    public static int subarraySum(int[] nums,int k){
        // 因为这个是求和，其实可以双指针搭配前缀和来进行处理
        // 思路错误1:不可以使用双指针的滑动窗口，虽然看起来是滑动的窗口，数组里有负数，窗口和不是单调的，缩窗口不能保证和变小
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0,count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0); // 需要记录个数
            // 编码错误1:我们不可以添加完所有的内容到map里面，而是必须要实时的去进行计算，因为你需要的是当前位置之前有多少个前缀和满足条件，不是全局的
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
