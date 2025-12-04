package Greedy;

//跳跃游戏2,求解最小跳跃次数
public class GD45 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        if(nums == null || nums.length == 1){
            return 0;
        }
        int count = 0;//实际走的步数
        int cur = 0;//当前下标最远可以到达的index
        int next = 0;//下一步最远可以达到的index
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);//next需要保证自己是这个区间里面最大的值，这个地方容易错！！！
            if (i == cur) {
                count++;//走一步,当前的part已经走完了
                cur = next;//进入到下一个part去走
                if (next > nums.length - 1) {
                    break;
                }
            }
        }
        return count;
    }
}
