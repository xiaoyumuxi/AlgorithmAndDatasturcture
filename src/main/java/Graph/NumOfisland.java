package Graph;

public class NumOfisland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}
        };
        System.out.println(findTheIsland(grid));
    }

    public static int nums = 0;
    public static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public static int findTheIsland(int[][] grid){
        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    // 编码错误2:这个不是无限制触发，而是在1的点才开始去dfs操作否则就忽略
                    dfs(grid,i,j);
                    nums++;
                    // 局部变量遮蔽的效果一定要小心，一般出现那种非常奇怪的结果的时候往往就需要思考一下是不是遍历遮蔽了
                }
            }
        }
        return nums;
    }

    public static boolean dfs(int[][] grid,int i,int j){
        if(i < 0 || i >= grid.length)return false;
        if(j < 0 || j >= grid[0].length)return false;
        if(grid[i][j] == 0)return false;
        
        grid[i][j] = 0;
        // 编码错误1:沉岛操作不应该可逆的，这个是DFS，可不是回溯算法，回溯算法才需要重置为1
        for(int x = 0; x < 4 ;x++){
            dfs(grid, i+dirs[x][0], j+dirs[x][1]);
        }

        return true;
    }
}
