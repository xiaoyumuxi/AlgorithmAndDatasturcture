package BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        char[][] nums = new char[n][n];
        for (char[] row : nums) Arrays.fill(row, '.');
        dfs(nums, 0, n);
        System.out.println(res);
    }

    public static List<List<String>> res = new ArrayList<>();
    public static List<String> path = new ArrayList<>();

    static Set<Integer> cols = new HashSet<>();
    static Set<Integer> d1 = new HashSet<>(); // 副对角线i+j相同
    static Set<Integer> d2 = new HashSet<>(); // 主对角线i-j相同

    public static void dfs(char[][] board, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || d1.contains(row - col) || d2.contains(row + col))
                continue;

            // 选择：放 Q + 标记
            board[row][col] = 'Q';
            cols.add(col);
            d1.add(row - col);
            d2.add(row + col);
            path.add(new String(board[row]));

            dfs(board, row + 1, n);

            // 撤销：全部恢复
            path.remove(path.size() - 1);
            board[row][col] = '.';
            cols.remove(col);
            d1.remove(row - col);
            d2.remove(row + col);
        }
    }

}
