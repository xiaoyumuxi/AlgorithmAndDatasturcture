package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class courseTable2 {
    public static void main(String[] args) {
        System.out.println(findPath(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

    public static List<Integer> findPath(int nums,int[][] list){
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[nums];
        for (int i = 0; i < nums; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : list) {
            graph.get(p[1]).add(p[0]);
            inDegree[p[0]]++;  
        }

        // 找到入度为0的点开始课程学习
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        // 然后从入度为0的地方开始进行扩展搜索
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            path.add(cur);
            // 只需要记录一下弹出的顺序即可，因为这个不是需要记录每一个起点的路径4->1,2->3这种和4->1->2->3的形式上表现是一样的
            for(int i : graph.get(cur)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    queue.offer(i);
                }
            }
        }

        return path;
    }
}
