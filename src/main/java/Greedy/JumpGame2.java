package Greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {2,3,0,1,4};
        System.out.println(minSetp(nums));
        System.out.println(minSetp(nums1));
    }

    public static int minSetp(int[] nums){
        int step = 0;
        int thisLevel = 0; // 表示当前层仅仅可以在[0,thisLevel]里面进行跳跃
        int nextLevel = 0; 
        for (int i = 0; i < nums.length - 1; i++) {
            // 编码错误1:因为如果到达nums.length - 1处那么就是意味着已经到末尾了不需要再跳了
            // 遍历所有需要做跳跃决策的位置"，终点不需要做决策，就不遍历它
            int x = i + nums[i];
            nextLevel = Math.max(x, nextLevel);
            if(i == thisLevel){
                step++;
                thisLevel = nextLevel;
            }
        }    
        return step;
    }
}
