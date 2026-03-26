package BackTrace;

import java.util.ArrayList;
import java.util.List;

public class CompletePermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(backtrace(nums));
    }   

    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> backtrace(int[] nums){
        boolean[] visit = new boolean[nums.length];
        dfs(nums, 0, visit);
        return res;
    }
    public static void dfs(int[] nums,int level,boolean[] visit){
        // 编码错误2:这里是必须要构建公共的path的副本的
        if(level == nums.length)res.add(new ArrayList<>(list));
        // 编码错误1:因为这个if是在最开始的时候执行的，因此在nums.length - 1处停下来就会导致少一层

        for (int i = 0; i < nums.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                list.add(nums[i]);
                dfs(nums, level + 1, visit);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}
