package Greedy;

import java.util.Arrays;

//K 次取反后最大化的数组和
public class GD1005 {
    public static void main(String[] args) {
        int[] A = {4, 2, 3};
        System.out.println(largestSumAfterKNegations(A, 1));
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);//直接排序
        for (int i = 0; i < A.length && K > 0; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];//反转
                K--;
            }
        }
        //这个时候多余的需要作用到正数上
        if (K % 2 == 1) {//如果k为偶数，不用进行操作了
            Arrays.sort(A);
            A[0] = -A[0];//如果k为奇数那么就作用到最小的正数即可
        }
        //求和
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}
