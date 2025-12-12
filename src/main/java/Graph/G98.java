package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G98 {//基础的bfs
    static List<List<Integer>> res = new ArrayList<>();//结果集
    static List<Integer> path = new ArrayList<>();//记录当前的路径
    int m, n;//m表示边，n表示点

    public static void main(String[] args) {
        test();
        get();
    }

    public void dfs(int p, List<List<Integer>> graph) {
        path.add(p);//当前点进入路径
        if (p == n) {
            //到达终点了，就将path进入结果集合
            res.add(new ArrayList<>(path));
        } else {
            //首先需要获取当前节点的邻居
            List<Integer> neighbors = graph.get(p);
            for (int v : neighbors) {
                dfs(v, graph);
            }
        }
        path.remove(path.size() - 1);//出来需要进行回溯
    }

    static void printPath(List<Integer> targetPath) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetPath.size(); i++) {
            sb.append(targetPath.get(i));
            if (i < targetPath.size() - 1) {
                sb.append("->");
            }
        }
        System.out.println(sb.toString());
    }

    public static void get(){//支持输入的
        Scanner scanner = new Scanner(System.in);

        // 检查是否有输入
        if (scanner.hasNext()) {
            int nInput = scanner.nextInt();
            int mInput = scanner.nextInt();

            // 1. 初始化对象
            G98 solver = new G98();
            solver.n = nInput;
            solver.m = mInput;

            // 2. 构建邻接表
            // 节点编号通常是 1 到 n，所以容量设为 n + 1
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= nInput; i++) {
                graph.add(new ArrayList<>());
            }

            // 3. 读取边信息
            for (int i = 0; i < mInput; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
            }

            // 4. 开始 DFS 搜索 (从节点 1 开始)
            solver.dfs(1, graph);

            // 5. 根据结果输出
            if (res.isEmpty()) {
                System.out.println("-1");
            } else {
                // 遍历结果集中的每一条路径进行打印
                for (List<Integer> singlePath : res) {
                    printPath(singlePath);
                }
            }
        }
        scanner.close();
    }

    static void test(){//硬编码
        G98 solver = new G98();
        int n = 5;
        solver.n = n;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(3);// 1 -> 3
        graph.get(1).add(2); // 1 -> 2
        graph.get(3).add(5);// 3 -> 5
        graph.get(2).add(4);// 2 -> 4
        graph.get(4).add(5);// 4 -> 5

        System.out.println("开始查找从 1 到 " + n + " 的所有路径...");
        solver.dfs(1, graph);
        if (res.isEmpty()) {
            System.out.println("-1");
        } else {
            for (List<Integer> singlePath : res) {
                printPath(singlePath);
            }
        }
    }
}
