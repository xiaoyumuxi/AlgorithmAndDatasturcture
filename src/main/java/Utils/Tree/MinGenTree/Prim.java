package Utils.Tree.MinGenTree;

import java.util.Arrays;

/**
 * Prim算法求解最小生成树
 * 适用于稠密图，时间复杂度O(n^2)
 */
public class Prim {
    private int n; // 顶点数量
    private int[][] graph; // 邻接矩阵表示的图
    private int[] minDist; // 存储每个节点到已选节点集合的最短距离
    private boolean[] visited; // 标记节点是否已被选择
    private int[] parent; // 记录每个节点在最小生成树中的父节点
    
    /**
     * 构造函数
     * @param n 顶点数量
     */
    public Prim(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.minDist = new int[n];
        this.visited = new boolean[n];
        this.parent = new int[n];
        
        // 初始化邻接矩阵为无穷大（表示无连接）
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
    }
    
    /**
     * 添加边
     * @param u 起点
     * @param v 终点
     * @param weight 权重
     */
    public void addEdge(int u, int v, int weight) {
        graph[u][v] = weight;
        graph[v][u] = weight; // 无向图
    }
    
    /**
     * Prim算法核心实现
     * @return 最小生成树的总权重
     */
    public int prim() {
        // 初始化
        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        
        // 从节点0开始构建最小生成树
        minDist[0] = 0;
        int totalWeight = 0;
        
        // 需要选择n个节点
        for (int i = 0; i < n; i++) {
            // 找到未访问节点中距离最小的节点
            int u = findMinDistanceNode();
            
            // 如果找不到有效节点，说明图不连通
            if (u == -1) {
                return -1;
            }
            
            // 将该节点标记为已访问
            visited[u] = true;
            totalWeight += minDist[u];
            
            // 更新与该节点相邻的所有未访问节点的距离
            updateDistances(u);
        }
        
        return totalWeight;
    }
    
    /**
     * 找到未访问节点中距离最小的节点
     * @return 节点索引，如果找不到返回-1
     */
    private int findMinDistanceNode() {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && minDist[i] < minValue) {
                minValue = minDist[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
    
    /**
     * 更新与指定节点相邻的所有未访问节点的距离
     * @param u 指定节点
     */
    private void updateDistances(int u) {
        for (int v = 0; v < n; v++) {
            // 如果节点v未被访问，且u与v之间有边，且这条边的权重小于当前记录的距离
            if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && graph[u][v] < minDist[v]) {
                minDist[v] = graph[u][v];
                parent[v] = u;
            }
        }
    }
    
    /**
     * 获取最小生成树的边
     * @return 边的数组，每条边用{起点, 终点, 权重}表示
     */
    public int[][] getMSTEdges() {
        int[][] edges = new int[n-1][3];
        int index = 0;
        
        for (int i = 1; i < n; i++) {
            edges[index][0] = parent[i];
            edges[index][1] = i;
            edges[index][2] = graph[parent[i]][i];
            index++;
        }
        
        return edges;
    }
    
    /**
     * 打印最小生成树
     */
    public void printMST() {
        System.out.println("最小生成树的边:");
        int[][] edges = getMSTEdges();
        int totalWeight = 0;
        
        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i][0] + " - " + edges[i][1] + " : " + edges[i][2]);
            totalWeight += edges[i][2];
        }
        
        System.out.println("最小生成树的总权重: " + totalWeight);
    }
}