package Graph.UnionFind;


import java.util.Scanner;

public class G109 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 假设输入第一行是 N (节点数/边数)
        if (!scanner.hasNext()) return;
        int n = scanner.nextInt();

        // 存储所有边，方便后续遍历 [u, v]
        int[][] edges = new int[n][2];

        // 1. 读取输入并记录入度
        // 注意：节点通常是 1 到 N，所以数组开 n+1
        int[] inDegree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges[i][0] = u;
            edges[i][1] = v;
            inDegree[v]++;
        }

        // 2. 寻找指向同一个点的两条边 (入度为2的情况)
        // candidate1 和 candidate2 分别记录这两条边的索引
        int candidate1 = -1;
        int candidate2 = -1;

        for (int i = 0; i < n; i++) {
            int v = edges[i][1];
            if (inDegree[v] == 2) {
                // 找到了入度为2的点，找出是指向它的哪两条边
                candidate2 = i; // 记录当前这条边（输入中靠后的）
                // 再找前一条指向 v 的边
                for (int j = 0; j < i; j++) {
                    if (edges[j][1] == v) {
                        candidate1 = j;
                        break;
                    }
                }
                break; // 题目保证最多只有一个节点入度为2
            }
        }

        // 3. 处理逻辑
        // 如果没有入度为2的情况，直接找环
        if (candidate1 == -1) {
            int[] result = findRedundantDirectedConnection(edges, -1);
            System.out.println(result[0] + " " + result[1]);
        } else {
            // 如果有入度为2的情况：
            // 先尝试“删除” candidate2 (靠后的那条)，看看剩下的图是否还有环
            if (isCycle(edges, n, candidate2)) {
                // 删了 candidate2 依然有环，说明 candidate2 不是冲突的根源（或者说它只是入度问题，不是环的问题）
                // 那一定是 candidate1 导致了冲突
                int[] e = edges[candidate1];
                System.out.println(e[0] + " " + e[1]);
            } else {
                // 删了 candidate2 就没有环了，说明 candidate2 就是我们要找的那个多余边
                int[] e = edges[candidate2];
                System.out.println(e[0] + " " + e[1]);
            }
        }
    }

    // 辅助方法：判断跳过 skipIndex 这条边后，图中是否有环
    static boolean isCycle(int[][] edges, int n, int skipIndex) {
        DisJoin dj = new DisJoin(n + 1);
        for (int i = 0; i < edges.length; i++) {
            if (i == skipIndex) continue; // 跳过这条边
            int u = edges[i][0];
            int v = edges[i][1];
            // 如果两个点已经在同一个集合，说明加上这条边会形成环
            if (!dj.union(u, v)) {
                return true;
            }
        }
        return false;
    }

    // 辅助方法：如果不考虑入度问题，直接返回导致环的那条边
    // 同时也用于 main 函数第一种情况（无入度为2）的调用
    static int[] findRedundantDirectedConnection(int[][] edges, int skipIndex) {
        DisJoin dj = new DisJoin(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (i == skipIndex) continue;
            int u = edges[i][0];
            int v = edges[i][1];
            if (!dj.union(u, v)) {
                return edges[i];
            }
        }
        return new int[0];
    }

    // 简单的并查集内部类 implementation
    static class DisJoin {
        int[] parent;

        public DisJoin(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // 路径压缩
            }
            return parent[x];
        }

        // 返回 boolean: true 表示成功合并，false 表示本身就在一个集合（有环）
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }
}