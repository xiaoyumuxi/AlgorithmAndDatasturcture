package Graph;

import java.util.Scanner;

public class G99_1 {//使用深度搜索来解决这类问题
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();//行数
            int m = in.nextInt();//列数
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }//获取输入

            boolean[][]visited =new boolean[n][m];//这里一定要和grid保持一致！！！
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j]&&grid[i][j]==1)
                    {
                        ans++;
                        visited[i][j]=true;
                        dfs(visited,i,j,grid);//一种特殊的写法而已
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}};//dir 数组定义了 4 个偏移量，分别对应 4 个移动方向

    static void dfs(boolean[][] visited, int x, int y, int[][] grid) {//(x,y)开始找，只需要验证(x+1,y),(x,y+1)的地方
        for (int i = 0; i < 4; i++) {
            int nextX=x+dir[i][0];
            int nextY=y+ dir[i][1];
            if(nextY<0||nextX<0||nextX>= grid.length||nextY>=grid[0].length)
                continue;
            if(!visited[nextX][nextY]&&grid[nextX][nextY]==1)
            {
                visited[nextX][nextY]=true;
                dfs(visited,nextX,nextY,grid);
            }
        }
    }
}
