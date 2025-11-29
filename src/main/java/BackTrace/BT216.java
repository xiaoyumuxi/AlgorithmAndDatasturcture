package BackTrace;

import java.util.ArrayList;
import java.util.List;

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
public class BT216 {
    public static void main(String[] args) {
        BT216 solution = new BT216();
        // 示例：找出 k=3 个数，和为 n=7 -> [[1, 2, 4]]
        // 注意：根据你的定义，第一个参数是 sum(n)，第二个是 count(k)
        System.out.println(solution.backTrace(7, 3));

        // 示例：找出 k=3 个数，和为 n=9 -> [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        System.out.println(solution.backTrace(9, 3));
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backTrace(int start, int n, int k, int sum) {
        //剪枝操作：如果当前和已经超过目标值，直接返回
        if (sum > n) {
            return;
        }

        if (path.size() == k) {
            if (sum == n) {//sum表示的是path数组的和
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backTrace(i + 1, n, k, sum + i);
            //回溯，这里需要注意因为我没有讲sum+=i单独拎出来，因此就不需要这个再sum-=i
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> backTrace(int n, int k) {
        res.clear();
        path.clear();

        backTrace(1, n, k, 0);
        return res;
    }
}
