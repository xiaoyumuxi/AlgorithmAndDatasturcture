package DP;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] n = {2,3,-2,4};
        System.out.println(muliplay2(n));
    }

    public static int muliplay(int[] num){
        int count = 0; // 负数的个数
        int left = 0; // 最左边的负数
        int right = 0; // 最右边的负数
        for (int i = 0; i < num.length; i++) {
            if(num[i]<0 && left == 0)left = num[i];
            if(num[i]<0)count++;
            if(num[i]==0){
                // 等于0就需要额外的逻辑了,二维0的个数也不知道，因此这部分还很复杂的,需要记录所有0的节点索引位置然后再去处理每一个区间
                // 然后每个区间里面还需要处理负数的数量
            }
        }
        for (int i = num.length - 1; i >= 0; i--) {
            if(num[i]<0 && right==0)right = num[i];
        }
        if(count % 2 == 0){
            // 返回所有的乘积
        }else{

        }
        return count;
    }

    public static int max = 0;

    public static int muliplay1(int[] nums){
        int curMax = 1;
        int curMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                curMax = curMin * nums[i];
                curMin = curMax * nums[i];
            }
            if(nums[i]>0){
                curMax = curMax * nums[i];
                curMin = curMin * nums[i];
            }
            if(nums[i]==0){
                max = Math.max(curMax, max);
                curMax = 1;
                curMin = 1;
            }
            // 这种讨论和分case其实就是已经有点类似贪心的算法了还是没有用到动态规划
        }
        return max;
    }

    public static int muliplay2(int[] nums){
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int prevMax = curMax;
            int prevMin = curMin;
            curMax = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
            res = Math.max(curMax, res);
            // 编码错误1:这里应该是三个值的比较还有一个nums[i]本身，也就是表示忽略前面的部分重新开始新的子数组
        }
        return res;
    }
}
