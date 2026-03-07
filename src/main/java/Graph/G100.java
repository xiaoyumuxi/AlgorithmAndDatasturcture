package Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class G100 {
    static int count;
    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            if (!in.hasNext()) return;

            int n = in.nextInt(); // 行
            int m = in.nextInt(); // 列
            int[][] grid = new int[n][m];

            // 读取网格
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            boolean[][] visited = new boolean[n][m];
            int maxArea = 0; // 用于记录所有岛屿中最大的那个面积

            // 遍历每一个格子
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 如果是陆地(1) 且 没访问过，说明发现了一座新岛屿
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        count = 0; // 重置计数器，开始计算这座新岛屿的面积

                        // 选用 DFS 或 BFS 其中一种即可
                        dfs(visited, i, j, grid);
                        // bfs(visited, i, j, grid);

                        // 更新最大面积
                        maxArea = Math.max(maxArea, count);
                    }
                }
            }

            System.out.println(maxArea);
        }
    }

    static void dfs(boolean[][] visited, int x, int y, int[][] grid) {
        visited[x][y] = true;
        count++; // 进来就加 1

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;

            if (visited[nextX][nextY] || grid[nextX][nextY] == 0)
                continue;

            dfs(visited, nextX, nextY, grid);
        }
    }

    static void bfs(boolean[][] visited, int x, int y, int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        count++; // 起点先加 1

        while (!q.isEmpty()) {
            int[] node = q.remove();
            int curX = node[0];
            int curY = node[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                    continue;

                if (visited[nextX][nextY] || grid[nextX][nextY] == 0)
                    continue;

                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                count++; // 每次入队时，面积 + 1
            }
        }
    }
}