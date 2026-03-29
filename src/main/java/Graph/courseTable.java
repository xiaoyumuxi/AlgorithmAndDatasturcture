package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class courseTable {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));          // true
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));    // false（环）
    }

    public static boolean canFinish(int nums,int[][] list){
        // 创建邻接表
        // 推荐写法，因为是连续的，因此不建议使用hash
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[nums];
        // 思路错误1:缺少入度数组没有办法开始遍历
        for (int i = 0; i < nums; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : list) {
            graph.get(p[1]).add(p[0]);
            inDegree[p[0]]++;  
        }
        // 判断是否可以完成学习->无环不出现死锁就可以完成

        // 找到入度为0的点开始课程学习
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        // 然后从入度为0的地方开始进行扩展搜索
        int count = 0;
        // 思路错误2:卡在使用BFS还是DFS寻找环上了，DFS是需要维护两种状态的——正在访问中和访问完毕，如果碰上了正在访问中那就是成环了
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for(int i : graph.get(cur)){
                inDegree[i]--;
                if(inDegree[i]==0)queue.offer(i);
            }
        }

        return count == nums;
    }
}
