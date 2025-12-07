package Greedy;

import java.util.Arrays;

public class GD452 {
    public static void main(String[] args) {

        // 示例 1
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("示例 1 输出: " + findMinArrowShots(points1)); // 预期: 2

        // 示例 2
        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println("示例 2 输出: " + findMinArrowShots(points2)); // 预期: 4

        // 示例 3
        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("示例 3 输出: " + findMinArrowShots(points3)); // 预期: 2
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));//这个写法是一定要会的
        int arrowShots = 1;
        int arrowPos = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > arrowPos) {//如果当前数组的左边界大于当前箭矢的位置，那么就需要新来一根箭矢了
                arrowPos = points[i][1];
                arrowShots++;
            }
        }
        return arrowShots;
    }
}
