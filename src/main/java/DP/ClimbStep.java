package DP;

public class ClimbStep {
    public static void main(String[] args) {
        System.out.println(Climb(3));
    }

    public static int Climb(int n){
        dfs(n, 0);
        return nums;
    }

    public static int nums = 0;

    // 明明可以使用DFS来进行解析的，为什么使用DP？
    public static void dfs(int n,int curSum){
        if(curSum == n)nums++;
        if(curSum > n)return;

        dfs(n, curSum+1);
        dfs(n, curSum+2);
    }
}
