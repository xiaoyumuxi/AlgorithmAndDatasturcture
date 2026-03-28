package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Orange {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orange(grid));
    }

    public static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    static int time = 0;

    // 思路错误1:BFS和DFS这里有点像，但是关键的区别就是BFS有扩散的概念和层的概念
    public static int orange(int[][] grid){
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0)return 0;

        // 开始进行扩散
        while(!queue.isEmpty()){
            int size = queue.size(); // 当前层的数量
            for (int i = 0; i < size; i++) {
                int[] k = queue.poll();
                for(int j = 0 ; j < 4 ; j++){
                    int x = k[0] + dirs[j][0];
                    int y = k[1] + dirs[j][1];
                    if(x < 0 || y < 0 || x >= m || y >= n)continue;
                    if(grid[x][y] != 1)continue;
                    // 编码错误1:这里不可以无条件入队，只有最外面一层的马上要加入的新鲜橘子才是有扩散能力的
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                    fresh--;
                }
            }
            time++;
        }

        return time;
    }
    
}
