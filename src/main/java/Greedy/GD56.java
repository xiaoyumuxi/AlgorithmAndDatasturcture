package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GD56 {
    public static void main(String[] args) {
        // 测试用例 1：最经典的例子
        // 相当于：[1,3], [2,6], [8,10], [15,18]
        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println("--- 测试 1 ---");
        System.out.println("输入: " + Arrays.deepToString(input1));
        int[][] result1 = merge(input1);
        System.out.println("输出: " + Arrays.deepToString(result1));
        // 预期输出: [[1, 6], [8, 10], [15, 18]]

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));//使用左边界来排列才是对的
        //右边界排序，目的是尽可能多地塞入区间
        List<int[]> res = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }else  {
                res.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        res.add(currentInterval);//需要将最后一个也放进去
        return res.toArray(new int[res.size()][]);
    }
}
