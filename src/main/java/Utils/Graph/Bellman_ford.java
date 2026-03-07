package Utils.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bellman_ford {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static List<Edge> edges = new ArrayList<>();
    static int[] minDist;
    static int start = 1;
    static int end;

    public Bellman_ford(int V, int E) {
        Bellman_ford.V = V;
        Bellman_ford.E = E;
    }

    public static void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            V = scanner.nextInt();
            E = scanner.nextInt();
            // 初始化minDist数组
            minDist = new int[V + 1];
            end = V;
            Arrays.fill(minDist, Integer.MAX_VALUE);
            minDist[start] = 0;//源点到源点的最短距离为0
            
            for(int i = 0; i < E; i++){
                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                int weight = scanner.nextInt();
                addEdge(src, dest, weight);
            }
        // 对所有的边松弛V-1次
        for(int i = 1; i < V; i++){
            boolean updated = false; // 优化：检测是否发生了更新
            for(Edge edge : edges){
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                if(minDist[src] != Integer.MAX_VALUE && minDist[src] + weight < minDist[dest]){
                    // src不可以为MAX，否则就不可以基于这个来对边进行更新
                    minDist[dest] = minDist[src] + weight;
                    updated = true;
                }
            }
            // 如果这一轮没有发生更新，可以提前结束
            if (!updated) break;
        }
        
        if(minDist[end] == Integer.MAX_VALUE){
            System.out.println("不能到达终点");
        } else {
            System.out.println(minDist[end]);
        }
        }
    }
}
