package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class spiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }
        System.out.println(spiralOrder(matrix));
        // 编码错误3:ArrayList是自带打印的方法的因此不需要使用toString等
        sc.close();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 需要一个数组来进行标记
        boolean[][] visit = new boolean[m][n];
        int direct = 0;
        // 0右，1下，2左，3上
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};//方向数组
        List<Integer> res = new ArrayList<>();
        int i=0,j=0;//当前所在的位置
        for (int k = 0; k < m * n; k++){
        // 编码错误1: 应该使用遍历次数来控制而不是使用边界来进行控制，螺旋走法里 i/j 可能会暂时变成负数或越界
            res.add(matrix[i][j]);//收集当前元素
            visit[i][j] = true;
            int ni = i + dirs[direct][0];
            int nj = j + dirs[direct][1];
            if(ni<0 || ni>=m || nj<0 || nj>=n || visit[ni][nj]){
                //已经访问过就需要掉转方向
                direct = (direct + 1) % 4;
                ni = i + dirs[direct][0];
                nj = j + dirs[direct][1];
                // 编码错误2: 重新换方向之后没有进行ni和nj的更新导致出现越界
            }
            i = ni;
            j = nj;
        }
        return res;
    }
}
