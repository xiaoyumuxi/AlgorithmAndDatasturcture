package DP;

public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canSpilt(nums));
    }

    public static boolean canSpilt(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum % 2 != 0)return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1]; // 表示能否凑到j
        // 思路错误1:这个dp数组有两种方案，需要根据语义来的，0-1背包问题关注的是要不要某一个元素，因此必须要是结果数组导向的
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            // 编码错误1:这里是对于nums数组必须从0开始的，如果是dp数组没有0没有关系，否则这里会出现漏值的情况的
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j-nums[i]] || dp[j];
                // 思路错误:dp[j]有两种方式，第一种就是之前就已经凑出过dp[j]这下不用选直接与，第二种就是之前凑出来过dp[j-nums[i]]
                // 然后这下就必须要选i了
            }
        }
        return dp[target];
    }
}
