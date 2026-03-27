package BackTrace;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        char[][] nums = new char[n][n];
        System.out.println();
    }

    public static List<List<String>> res = new ArrayList<>();
    public static List<String> path = new ArrayList<>();


    public static void dfs(char[][] nums,int row,int n){
        if(row == n + 1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < nums[0].length ; i++){
            // 将Q放到这个位置然后将棋盘不可以访问的地方标记成#
            dfs(nums, row + 1, n);
        }
    }

    public static boolean isVaild(char[][] nums,int i,int j,boolean[][] canPut){

        if(canPut[i][j]!=false){
            nums[i][j] = 'Q';
            for(int x = 0 ; x < nums[0].length ; x++){
                if(x == j)continue;
                nums[i][x] = '.';
            }
            // 放了之后还需要将canPut更新一下
            for(int x = 0 ; x < nums[0].length ; x++){
                canPut[i][x] = false;
            }// 横着
            for (int k = 0; k < canPut.length; k++) {
                canPut[k][j] = false;
            }// 竖着
            for(int x = 0 ; (i + x) < nums.length 
                && (j + x) < nums[0].length && (i - x) >= 0 && (j - x) >= 0 ;x++){
                    canPut[i+x][j+x] = false;
                    canPut[i-x][j-x] = false;
                    canPut[i+x][j-x] = false;
                    canPut[i-x][j+x] = false;
            }// 这里应该是六个循环，混在一起反而错了，而且没有办法回溯
            return true;
        }
        else return false;
    }
}
