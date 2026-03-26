package BackTrace;

import java.util.ArrayList;
import java.util.List;

public class subSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(backtrace(nums));
    }

    public static List<List<Integer>> backtrace(int[] nums){
        dfs(nums, 0);
        return res;
    }

    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static void dfs(int[] nums,int start){
        res.add(new ArrayList<>(path));
        // 思路错误1:子集是所有可能都要加进去的因此每一个dfs都要add

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i+1);
            // 编码错误1:这里是i+1不是start+1,因为start表示这一次只考虑[start::end]的nums里面的数了
            path.remove(path.size()-1);
        }
    }
}
