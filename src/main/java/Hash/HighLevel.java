package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighLevel {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        // 编码错误1:小根堆但是比较的元素是根据频率来的
        for (int key : map.keySet()) {   
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }// 一旦超过k个就需要进行弹出
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
