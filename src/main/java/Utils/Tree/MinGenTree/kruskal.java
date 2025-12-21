package Utils.Tree.MinGenTree;

import Utils.UnionFind.DisJoin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal算法求解最小生成树
 * 适用于稀疏图，时间复杂度O(E log E)，其中E是边数
 */
public class kruskal {
    // 边的内部类
    static class Edge implements Comparable<Edge> {
        int start;    // 起点
        int end;      // 终点
        int weight;   // 权重
        
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    private int n; // 顶点数量
    private List<Edge> edges; // 边的列表
    
    /**
     * 构造函数
     * @param n 顶点数量
     */
    public kruskal(int n) {
        this.n = n;
        this.edges = new ArrayList<>();
    }
    
    /**
     * 添加边
     * @param u 起点
     * @param v 终点
     * @param weight 权重
     */
    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }
    
    /**
     * Kruskal算法核心实现
     * @return 最小生成树的总权重
     */
    public int kruskal() {
        // 将边按权重排序
        Collections.sort(edges);
        
        // 初始化并查集
        DisJoin disjointSet = new DisJoin(n);
        
        int totalWeight = 0;
        int edgeCount = 0;
        
        // 遍历所有边
        for (Edge edge : edges) {
            // 如果当前边的两个端点不在同一连通分量中
            if (!disjointSet.isSame(edge.start, edge.end)) {
                // 将这两个端点合并到同一连通分量中
                disjointSet.join(edge.start, edge.end);
                // 累加权重
                totalWeight += edge.weight;
                // 边数加一
                edgeCount++;
                
                // 如果已经选择了n-1条边，则最小生成树构造完成
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        // 如果选择的边数不足n-1条，说明图不连通
        if (edgeCount < n - 1) {
            return -1;
        }
        
        return totalWeight;
    }
    
    /**
     * 获取最小生成树的边
     * @return 最小生成树的边列表
     */
    public List<Edge> getMSTEdges() {
        // 将边按权重排序
        Collections.sort(edges);
        
        // 初始化并查集
        DisJoin dj = new DisJoin(n);
        
        List<Edge> mstEdges = new ArrayList<>();
        
        // 遍历所有边
        for (Edge edge : edges) {
            // 如果当前边的两个端点不在同一连通分量中
            if (!dj.isSame(edge.start, edge.end)) {
                // 将这两个端点合并到同一连通分量中
                dj.join(edge.start, edge.end);
                // 将边加入最小生成树
                mstEdges.add(edge);
                
                // 如果已经选择了n-1条边，则最小生成树构造完成
                if (mstEdges.size() == n - 1) {
                    break;
                }
            }
        }
        
        return mstEdges;
    }
    
    /**
     * 打印最小生成树
     */
    public void printMST() {
        List<Edge> mstEdges = getMSTEdges();
        int totalWeight = 0;
        
        System.out.println("最小生成树的边:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.start + " - " + edge.end + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        
        System.out.println("最小生成树的总权重: " + totalWeight);
    }
}