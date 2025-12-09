package Greedy;

import java.util.ArrayList;
import java.util.List;

public class GD763 {
    public static void main(String[] args) {
        String s1 = "ababcbacadefegdehijhklij";

        List<Integer> result1 = partitionLabels(s1);

        // 打印结果
        System.out.println("测试用例 1:");
        System.out.println("输入: " + s1);
        System.out.println("输出: " + result1); // 预期输出: [9, 7, 8]
    }

    public static List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();
        int[] next = new int[26];
        for (int i = 0; i < arr.length; i++) {
            next[arr[i] - 'a'] = i;//使用哈希表记录对应字母出现的最远距离
        }
        //进行划分
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, next[arr[i] - 'a']);//更新末尾位置
            if (i == end) {//两个值相等就开始截断
                ans.add(end - start + 1);
                start = end + 1;//重置起始位置
            }
        }
        return ans;
    }
}
