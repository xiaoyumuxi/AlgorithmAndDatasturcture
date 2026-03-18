package Hash;

public class OneTimeNum {
    public static void main(String[] args) {
        int[] n = {4,1,2,1,2};
        System.out.println(singleNumber(n));
    }   

    public static int singleNumber(int[] nums) {
        int a = 0;

        for(int i = 0 ; i < nums.length - 1 ;i++){
            a ^= nums[i];
            // 想到了抵消但是卡住了常数里面怎么使用抵消，忽略了位运算
        }
        return a;
    }
}
