package BackTrace;

public class searchWord {
    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(search(a, "ABCCED"));
    }

    public static boolean search(char[][] board,String word){
        // 编码错误1:起点不唯一
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {          // 遍历所有起点
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return find;
    }

    static StringBuilder sb = new StringBuilder();
    static boolean find = false;
    static int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};


    public static boolean dfs(char[][] board,String word,int i,int j,int index){
        int row = board.length;
        int col = board[0].length;
        // 编码错误2:row和col的对应关系老是遗忘
        
        if (index == word.length()) return true;

        if (i < 0 || i >= row ||
            j < 0 || j >= col) return false; // 越界

        if(board[i][j] != word.charAt(index))return false;

        char temp = board[i][j];

        board[i][j] = '#'; //标记访问过
        // 编码错误3:不可以重复访问缺乏标记的思路，而且往往第一反应都是visit数组了，这个就证明其实访问了
        // 因为这里已经访问过的'#'会和word.charAt(index)不匹配而跳过，因此不用我们手动掉转方向

        for (int[] d : dirs) {
            if (dfs(board, word, i + d[0], j + d[1], index + 1))
                return true;
        }

        board[i][j] = temp;

        return false;
    }
}
