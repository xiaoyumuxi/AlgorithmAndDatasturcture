package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class divideIntervals {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(divide(s));
    }

    public static List<Integer> divide(String s){
        char[] ch = s.toCharArray();
        int[][] interval = new int[26][2];
        for (int[] a : interval) Arrays.fill(a, -1); // 编码错误6: 这里是二维数组因此不可以直接使用Arrays.fill()
        // 记录区间
        for (int i = 0; i < ch.length; i++) {
            if (interval[ch[i] - 'a'][0] == -1) {
                // 编码错误2:默认初始化值为0那么i=0就会卡死
                interval[ch[i] - 'a'][0] = i;
            }
            interval[ch[i] - 'a'][1] = i;
                // 编码错误7:这里的右边界不是只有刚开始进行更新的时候更新，而是每一次都需要更新
        }
        // 根据左区间合并
        Arrays.sort(interval,(o1,o2) -> o1[0] - o2[0]);

        List<Integer> list = new ArrayList<>();

        // 找到第一个出现过的字母
        int start = 0;
        while (start < 26 && interval[start][0] == -1) start++;
        // 思路错误1:因为有大量的-1的脏数据，因此我们得跳过这些脏数据部分的内容，主要是为了确保curr不是脏数据

        int prev = interval[start][0]; 
        int curr = interval[start][1];   

        for (int i = start; i < interval.length - 1; i++) {
            // 编码错误1:区间越界注意
            if (interval[i + 1][0] == -1) continue;  // 跳过没出现的
            if(curr < interval[i+1][0]){
                // 新的区间
                list.add(curr - prev + 1);// 编码错误3:这里是加区间长度
                prev = curr + 1;// 编码错误5:这里需要完全断开，因此不可以prev = curr;
                curr = interval[i + 1][1];
                // 编码错误8:这里应该是curr < interval[i+1][0]而不是interval[i][1] < interval[i+1][0]
            }else{
                // 不用开新区间
                curr = Math.max(curr, interval[i + 1][1]);
            }

        }
        list.add(curr - prev + 1);// 编码错误4:最后一个没有加入到list中去

        return list;
    }
}
