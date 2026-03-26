package BackTrace;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        System.out.println(backtrace(a, 7));
    }

    public static List<List<Integer>> backtrace(int[] candidates,int target){
        dfs(candidates,  target);
        return res;
    }

    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static int curSum = 0;

    public static void dfs(int[] candidates,int target){
        if(curSum > target) return;  // 超过了，直接剪掉
        // 编码错误1:主要是少了这个超出就剪枝的代码
        if(curSum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            curSum += candidates[i];
            dfs(candidates,target);
            curSum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
