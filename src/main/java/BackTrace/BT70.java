package BackTrace;

import java.util.ArrayList;
import java.util.List;

//给定两个整数n和k，返回范围[1, n]中所有可能的k个数的组合
public class BT70 {
    public static void main(String[] args) {
        BT70 solution = new BT70();

        int n = 4;
        int k = 2;

        List<List<Integer>> result = solution.backTrace(n, k);

        System.out.println("输出结果: " + result);
    }

    List<List<Integer>> res = new ArrayList<>();//结果集
    List<Integer> path = new ArrayList<>();//每一个有效的多元元组(也是list)

    private void backTrace(int n, int k, int startIndex) {
        //
        if (path.size() == k) {//path列表装满了k个元素立刻返回
            //res.add(path);
            res.add(new ArrayList<>(path));//必须存的是path的副本，否则会改变原来的path
            return;
        }
        //没有装满k个就需要进行遍历了
        //题目要求是 [1, n]，是可以取到 n 的，所以是 i <= n
        for (int i = startIndex; i <= n; i++) {//横向遍历
            //这里path中有path.size()个元素，还需要k-path.size()个元素，因此我们只需要遍历到n - (k - path.size()) + 1
            path.add(i);//向path里面添加一个元素
            backTrace(n, k, i + 1);//找剩下需要的元素
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> backTrace(int n, int k) {
        // 每次调用前最好清空一下成员变量，防止同一个对象被多次调用导致结果出错
        res.clear();
        path.clear();

        backTrace(n, k, 1);
        return res;
    }
}
