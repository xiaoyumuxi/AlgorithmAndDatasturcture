package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class rotatePhoto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        sc.close();
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0 ; i < n / 2 ; i++){
        // 编码错误1:因为这里范围到了n，因此就是其实被连续交换了四次所以导致最后出现一样的矩阵，需要改成n/2
            for(int j = 0 ; j < (n+1) / 2 ; j++){
            // 编码错误2:当n为奇数的时候中心点是不用进行移动的，因此i和j里面有一个需要向上取整
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
