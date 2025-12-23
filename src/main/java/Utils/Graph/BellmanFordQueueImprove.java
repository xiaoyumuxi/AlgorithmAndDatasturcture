import java.util.*;

public class BellmanFordQueueImprove {
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        // 1. 使用邻接表代替全边遍历
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adj.get(u).add(new Edge(v, w));
        }

        int start = 1;
        int[] minDist = new int[V + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        // 2. 优化：记录点是否已经在队列中
        boolean[] isInQueue = new boolean[V + 1];
        // 3. 可选：记录入队次数用于检测负环
        int[] count = new int[V + 1];

        // JDK 17: 使用 ArrayDeque 性能通常优于 LinkedList
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        isInQueue[start] = true;
        count[start] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            isInQueue[u] = false; // 出队后重置状态

            // 只遍历与 u 相连的边
            for (Edge edge : adj.get(u)) {
                if (minDist[u] != Integer.MAX_VALUE && minDist[edge.to] > minDist[u] + edge.weight) {
                    minDist[edge.to] = minDist[u] + edge.weight;

                    if (!isInQueue[edge.to]) {
                        queue.offer(edge.to);
                        isInQueue[edge.to] = true;
                        count[edge.to]++;

                        // 检测负环
                        if (count[edge.to] >= V) {//如果对一个边松弛的次数超过了V次还在进行就表示有负环
                            System.out.println("图中存在负权回路！");
                            return;
                        }
                    }
                }
            }
        }

        // 输出结果
        for (int i = 1; i <= V; i++) {
            System.out.println("到 " + i + " 的最短距离: " + (minDist[i] == Integer.MAX_VALUE ? "不可达" : minDist[i]));
        }
    }
}