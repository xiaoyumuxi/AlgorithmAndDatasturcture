package Greedy;

import java.util.Arrays;

public class GD455 {
    public static void main(String[] args) {
        int[] g ={1,2,7,20};
        int[] s = {1,3,5,9};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);//先进行排序，然后最大的饼干给符合的最大的人选
        int count = 0;
        int j = s.length - 1;//这个地方需要注意！！！，一旦饼干符合就不能在回退了，因此这个在循环外面声明的
        for (int i = g.length - 1; i >= 0; i--) {
            if (j > 0 && g[i] <= s[j]) {
                j--;
                count++;
            }
        }
        return count;
    }
}
