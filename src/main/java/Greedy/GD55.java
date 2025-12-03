package Greedy;

public class GD55 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
        int[] arr2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr2));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;// max 代表当前能到达的最远下标
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;//这个是关键，因为这个不一定能到最后末尾处，如果没有这一行那么对所有的arr都是可以到达的，永远为true
            max = Math.max(max, nums[i] + i);
            if (max > nums.length) {
                return true;
            }
        }
        return false;
    }
}
