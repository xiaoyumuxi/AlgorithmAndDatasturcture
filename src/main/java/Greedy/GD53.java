package Greedy;

//最大子序和
public class GD53 {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        int[] arr2 = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.printf("%d",maxSubArray(arr2));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;//这里必须初始化为最小负数
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > max){max = sum;}//更新最大值
            //这里需要先尝试更新最大值而不是进行归零，否则没有办法应对arr2的情况
            if(sum <= 0){sum = 0;}//如果小于立马归零
        }
        return max;
    }
}
