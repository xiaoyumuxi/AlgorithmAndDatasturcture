package Greedy;

import java.util.Arrays;

public class GD435 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(eraseOverlapIntervals(intervals)); // 应该输出 1
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return o1[1] - o2[1];//返回负数表示 o1 排在 o2 前面
            } else return o2[1] - o1[1];
        });//排序根据最右边
        //Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0],o2[0]));这种是更常用的写法，避免比较出现错误
        //后面的内容和GD452没什么区别
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++; // 这个区间不冲突，保留它
                end = intervals[i][1]; // 更新结束时间为这个新区间的结束时间
            }
            //else就是出现冲突了，那么保留结束早的（也就是原来的 end），放弃现在的，就不需要进行操作
        }
        return intervals.length - count;//总数 - 最多能保留几个 = 最少移除几个
        //最少移除这种问题都是很难解决的，涉及最佳方案需要考虑正难则反
    }
}
