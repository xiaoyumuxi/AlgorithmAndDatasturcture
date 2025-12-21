package Graph.MinGenTree;

import Utils.UnionFind.DisJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class G53 {
    private static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        for (int i = 0; i < e; i++) {
            Edge edge = new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            edges.add(edge);
        }//获取输入

        Collections.sort(edges);//边排序
        int totalWeight = 0;
        int edgeCount = 0;
        DisJoin dj = new DisJoin(v + 1);//从1开始这里需要+1！！！

        for(Edge edge : edges){
            if(!dj.isSame(edge.start, edge.end)){
                //不在同一个集合才是有效的可选的
                dj.join(edge.start, edge.end);//加入一个集合
                totalWeight += edge.weight;
                edgeCount++;
            }

            if(edgeCount == v - 1){
                break;
            }
        }

        if(edgeCount  < v -1){
            System.out.println("无最小生成树,图不连通");
        }
        System.out.printf("最小长度是%d",totalWeight);

    }
}
class Edge implements Comparable<Edge>{
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