package Utils.Graph;

import java.util.*;

/**
 * 拓扑排序工具类
 * 提供基于 Kahn 算法和 DFS 算法的拓扑排序实现
 */
public class TopologicalSort {
    
    /**
     * 使用 Kahn 算法进行拓扑排序
     * 
     * @param numVertices 顶点数量
     * @param edges 边的集合，每个元素为 [from, to] 形式的数组
     * @return 拓扑排序结果，如果存在环则返回空列表
     */
    public static List<Integer> kahnTopologicalSort(int numVertices, int[][] edges) {
        // 构建邻接表和入度数组
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[numVertices];
        
        // 初始化邻接表
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        // 填充邻接表和入度数组
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            // 验证顶点索引是否合法
            if (from < 0 || from >= numVertices || to < 0 || to >= numVertices) {
                throw new IllegalArgumentException("顶点索引超出范围: from=" + from + ", to=" + to);
            }
            
            adjacencyList.get(from).add(to);
            inDegree[to]++;
        }
        
        // 将所有入度为0的顶点加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        // 处理队列中的顶点
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            
            // 更新相邻顶点的入度
            for (int neighbor : adjacencyList.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 如果结果中的顶点数小于总顶点数，说明存在环
        if (result.size() != numVertices) {
            return new ArrayList<>(); // 返回空列表表示存在环
        }
        
        return result;
    }
    
    /**
     * 使用深度优先搜索(DFS)进行拓扑排序
     * 
     * @param numVertices 顶点数量
     * @param edges 边的集合，每个元素为 [from, to] 形式的数组
     * @return 拓扑排序结果，如果存在环则返回空列表
     */
    public static List<Integer> dfsTopologicalSort(int numVertices, int[][] edges) {
        // 构建邻接表
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        // 初始化邻接表
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        // 填充邻接表
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            // 验证顶点索引是否合法
            if (from < 0 || from >= numVertices || to < 0 || to >= numVertices) {
                throw new IllegalArgumentException("顶点索引超出范围: from=" + from + ", to=" + to);
            }
            
            adjacencyList.get(from).add(to);
        }
        
        // 0: 未访问, 1: 正在访问, 2: 已完成访问
        int[] visited = new int[numVertices];
        Stack<Integer> stack = new Stack<>();
        
        // 对每个未访问的顶点执行DFS
        for (int i = 0; i < numVertices; i++) {
            if (visited[i] == 0) {
                if (!dfsUtil(i, adjacencyList, visited, stack)) {
                    return new ArrayList<>(); // 存在环，返回空列表
                }
            }
        }
        
        // 构建结果列表
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
    
    /**
     * DFS辅助方法
     * 
     * @param vertex 当前访问的顶点
     * @param adjacencyList 邻接表
     * @param visited 访问状态数组
     * @param stack 用于存储拓扑排序结果的栈
     * @return 如果存在环返回false，否则返回true
     */
    private static boolean dfsUtil(int vertex, List<List<Integer>> adjacencyList, int[] visited, Stack<Integer> stack) {
        // 标记当前顶点为正在访问
        visited[vertex] = 1;
        
        // 访问所有邻居顶点
        for (int neighbor : adjacencyList.get(vertex)) {
            // 如果邻居顶点正在访问中，说明存在环
            if (visited[neighbor] == 1) {
                return false;
            }
            
            // 如果邻居顶点未访问，递归访问
            if (visited[neighbor] == 0) {
                if (!dfsUtil(neighbor, adjacencyList, visited, stack)) {
                    return false;
                }
            }
        }
        
        // 标记当前顶点为已完成访问，并将其加入栈中
        visited[vertex] = 2;
        stack.push(vertex);
        return true;
    }
    
    /**
     * 检查有向图中是否存在环
     * 
     * @param numVertices 顶点数量
     * @param edges 边的集合，每个元素为 [from, to] 形式的数组
     * @return 如果存在环返回true，否则返回false
     */
    public static boolean hasCycle(int numVertices, int[][] edges) {
        // 使用DFS方法检查环，如果返回空列表说明存在环
        return dfsTopologicalSort(numVertices, edges).isEmpty();
    }
}