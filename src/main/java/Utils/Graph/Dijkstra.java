package Utils.Graph;

import java.util.*;

/**
 * Dijkstra算法工具类
 * 提供计算图中单源最短路径的功能
 */
public class Dijkstra {
    
    /**
     * 使用Dijkstra算法计算从源顶点到其他各顶点的最短距离
     * 
     * @param numVertices 顶点数量
     * @param edges 带权重的边集合，每个元素为 [from, to, weight] 形式的数组
     * @param source 起始顶点
     * @return 从源顶点到各顶点的最短距离数组，如果图中存在负权边则抛出异常
     */
    public static int[] dijkstra(int numVertices, int[][] edges, int source) {
        // 检查源顶点是否有效
        if (source < 0 || source >= numVertices) {
            throw new IllegalArgumentException("源顶点索引超出范围: " + source);
        }
        
        // 检查是否存在负权边
        for (int[] edge : edges) {
            if (edge.length < 3) {
                throw new IllegalArgumentException("边的信息不完整，需要包含起点、终点和权重");
            }
            if (edge[2] < 0) {
                throw new IllegalArgumentException("Dijkstra算法不支持负权边: " + Arrays.toString(edge));
            }
        }
        
        // 构建邻接表
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        // 填充邻接表
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            
            // 验证顶点索引是否合法
            if (from < 0 || from >= numVertices || to < 0 || to >= numVertices) {
                throw new IllegalArgumentException("顶点索引超出范围: from=" + from + ", to=" + to);
            }
            
            adjacencyList.get(from).add(new int[]{to, weight});
        }
        
        // 初始化距离数组，所有距离初始化为无穷大
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        
        // 使用优先队列（最小堆）来选择下一个要处理的顶点
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});
        
        // 记录已访问的顶点
        boolean[] visited = new boolean[numVertices];
        
        // Dijkstra算法主循环
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int distance = current[1];
            
            // 如果顶点已被访问过，则跳过
            if (visited[vertex]) {
                continue;
            }
            
            // 标记顶点为已访问
            visited[vertex] = true;
            
            // 更新相邻顶点的距离
            for (int[] neighbor : adjacencyList.get(vertex)) {
                int nextVertex = neighbor[0];
                int edgeWeight = neighbor[1];
                
                // 如果通过当前顶点到达相邻顶点的路径更短，则更新距离
                if (!visited[nextVertex] && distances[vertex] != Integer.MAX_VALUE &&
                    distances[vertex] + edgeWeight < distances[nextVertex]) {
                    distances[nextVertex] = distances[vertex] + edgeWeight;
                    pq.offer(new int[]{nextVertex, distances[nextVertex]});
                }
            }
        }
        
        return distances;
    }
    
    /**
     * 使用Dijkstra算法计算从源顶点到目标顶点的最短距离
     * 
     * @param numVertices 顶点数量
     * @param edges 带权重的边集合，每个元素为 [from, to, weight] 形式的数组
     * @param source 起始顶点
     * @param target 目标顶点
     * @return 从源顶点到目标顶点的最短距离，如果无法到达或图中存在负权边则抛出异常
     */
    public static int dijkstra(int numVertices, int[][] edges, int source, int target) {
        // 检查目标顶点是否有效
        if (target < 0 || target >= numVertices) {
            throw new IllegalArgumentException("目标顶点索引超出范围: " + target);
        }
        
        // 获取所有顶点的最短距离
        int[] distances = dijkstra(numVertices, edges, source);
        
        // 返回到目标顶点的距离
        return distances[target] == Integer.MAX_VALUE ? -1 : distances[target];
    }
    
    /**
     * 使用Dijkstra算法获取从源顶点到其他各顶点的最短路径
     * 
     * @param numVertices 顶点数量
     * @param edges 带权重的边集合，每个元素为 [from, to, weight] 形式的数组
     * @param source 起始顶点
     * @return 从源顶点到各顶点的最短路径信息映射，键为终点，值为最短距离
     */
    public static Map<Integer, Integer> dijkstraWithPaths(int numVertices, int[][] edges, int source) {
        int[] distances = dijkstra(numVertices, edges, source);
        Map<Integer, Integer> result = new HashMap<>();
        
        for (int i = 0; i < numVertices; i++) {
            if (distances[i] != Integer.MAX_VALUE) {
                result.put(i, distances[i]);
            } else {
                result.put(i, -1); // 表示无法到达
            }
        }
        
        return result;
    }
}