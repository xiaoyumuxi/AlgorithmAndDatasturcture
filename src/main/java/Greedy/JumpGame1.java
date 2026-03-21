package Greedy;

public class JumpGame1 {
    public static void main(String[] args) {
        //int[] n = {2,3,1,1,4};
        int[] n1 = {3,2,1,0,4};
        //System.out.println(canReach(n));
        System.out.println(canReach(n1));
    }

    public static boolean canReach(int[] nums){
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxReach)return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if(maxReach >= nums.length - 1)return true;
        }
        return true;
    }
}
