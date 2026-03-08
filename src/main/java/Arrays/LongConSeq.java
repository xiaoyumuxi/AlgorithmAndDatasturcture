package Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongConSeq{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(get(nums));
        sc.close();
    }

    public static int get(int[] nums){
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i = 0 ; i < nums.length ; i++){
            int max = find(nums[i],set);
            len = Math.max(max, len);
        }
        return len;
    }

    public static int find(int num,Set<Integer> set){
        //返回从num开始连续的最长序列的长度
        int len = 1;
        while(true){
            if(set.contains(num + 1)){
                num += 1;
                len += 1;
                // 编码错误1:这里漏掉了一个len++的操作
            }else{
                return len;
            }
        }
    }
}