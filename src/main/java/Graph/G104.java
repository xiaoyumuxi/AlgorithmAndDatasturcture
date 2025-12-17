package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class G104 {
    public static void main(String[] args) {
        // 接收输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        mark = 2;//进行初始化，海洋为0,陆地为1
        boolean[][] visited = new boolean[m][n];

        HashMap<Integer,Integer> map = new HashMap<>();//用来存一个岛屿的mark和对应的面积大小

        // 遍历二维数组进行DFS搜索，标记每片岛屿的编号，记录对应的面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 0)continue;
                if(grid[i][j] == 1){
                    count = 0;//重置岛屿面积计数
                    dfs(grid,i,j,visited);
                    map.put(mark,count);
                    mark++;
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int currentArea = 1;
                    Set<Integer> connectedIslands = new HashSet<>();//创建一个集合,用于去重，防止连接到同一个岛屿的不同部位
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        // 判断边界
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            int neighborMark = grid[ni][nj];
                            // 如果邻居是岛屿（标记大于1），且这个岛屿还不在集合里面
                            if (neighborMark > 1 && !connectedIslands.contains(neighborMark)) {
                                currentArea += map.get(neighborMark);
                                connectedIslands.add(neighborMark);
                            }
                        }
                        maxArea = Math.max(maxArea, currentArea);
                    }
                }
            }
        }
        System.out.println(maxArea);

    }

    static int count;//这个记录岛的面积
    static int mark;//这个来进行不同岛的标记
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//依旧使用二维数组来进行dfs

    public static void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        // 当遇到边界，直接return
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        // 遇到已经访问过的或者遇到海水，直接返回
        if (visited[x][y] || grid[x][y] == 0) return;

        visited[x][y] = true;
        count++;
        grid[x][y] = mark;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            dfs(grid, nextX, nextY, visited);
        }
    }

}
