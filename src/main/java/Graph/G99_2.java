package Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class G99_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//行数
        int m = in.nextInt();//列数
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }//获取输入
        boolean[][] visited = new boolean[n][m]; // 建议用 boolean，清晰
        int ans = 0; // 记录岛屿数量

        // 1. 遍历每一个格子，寻找没去过的陆地
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans++; // 发现新岛屿(对应存在值+没有被访问过)
                    bfs(visited, i, j, grid); // 启动 BFS，每一次BFS都会将附近上下左右的所有存在的点都设置为已访问
                }
            }
        }
        System.out.println(ans);
    }

    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//下右上左逆时针遍历

    public static void bfs(boolean[][] visited, int x, int y, int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();//队列里面存的是坐标不是对应的值
        queue.offer(new int[]{x, y});
        visited[x][y] = true;//将当前坐标入队，然后将其标记为已访问
        while (!queue.isEmpty()) {//只有队列里面的元素全空才会停止
            // 取出队头元素
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 关键点4：向四个方向扩散
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                // 越界检查
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }

                // 如果是陆地(1) 且 没被访问过
                if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
