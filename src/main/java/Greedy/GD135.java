package Greedy;

import java.util.Arrays;

public class GD135 {
    public static void main(String[] args) {
        int[] rating = {1, 0, 2};
        System.out.println(candy(rating));
        int[] rating1 = {3, 2, 1}; // 和为6
        System.out.println(candy(rating1));
    }

    public static int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        //初始化为1
        Arrays.fill(res, 1);
        //从左到右开始构建
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        //从右往左开始构建
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int re : res) {
            sum += re;
        }
        return sum;
    }
}
