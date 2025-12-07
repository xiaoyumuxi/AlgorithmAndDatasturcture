package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class GD406 {
    public static void main(String[] args) {
        int[][] people = {{6, 0},{5, 0},{4, 0},{3, 2},{2, 2},{1, 4}};
        int[][] result = reconstructQueue(people);//需要使用Arrays.deepToString 包裹来打印里面的内容
        System.out.println(Arrays.deepToString(result));//直接调用toString没有重写自动出来的是HashCode
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
            return b[0] - a[0];// 优先使用h来进行排队，b - a表示的是降序(在a[0]!=b[0]的情况下才这样)
        });//使用h来作为排序关键

        LinkedList<int[]> queue = new LinkedList<>();//使用链表
        for (int[] p : people) {
            queue.add(p[1], p);//按照p[1]的值来进行排序
        }

        return queue.toArray(new int[people.length][]);//将其转换成对应的数组
    }
}