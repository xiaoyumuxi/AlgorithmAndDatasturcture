package Greedy;

public class JumpGame1 {
    public static void main(String[] args) {
        //int[] n = {2,3,1,1,4};
        int[] n1 = {3,2,1,0,4};
        //System.out.println(canReach(n));
        System.out.println(canReach(n1));
    }

    public static boolean canReach(int[] nums){
        int[] maxReach = new int[nums.length];
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if(canReach[i] == true)maxReach[i] = i + nums[i];
            else continue;
            // 编码错误1:不能到达的部分还是没有跳过后面的逻辑
            if(maxReach[i] < nums.length)canReach[maxReach[i]] = true;
            if(maxReach[i] > nums.length)return true;
            // 思路错误1:关键是最开始我们不可以确认这个i是不是可达的呀
        }
        return false;
    }
}
