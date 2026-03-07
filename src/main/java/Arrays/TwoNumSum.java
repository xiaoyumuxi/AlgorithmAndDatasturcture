package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoNumSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 编码错误1:使用增强for循环进行赋值，但是增强for循环是用来遍历处理的，本质是进行了复制操作，因此进行赋值不会改变nums
        // 数组导致数组原来还是空的
        int target = sc.nextInt();
        System.out.println(Arrays.toString(findIndex(nums, target)));
        // 编码错误2:使用sout直接答应数组会直接打印出来地址的，需要使用Arrays.toString()方法来进行转换
        sc.close();
    }

    public static int[] findIndex(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{ map.get(need), i };
            }
            map.put(nums[i], i);
        }
        // 编码问题1:想将所有的数据放入到HashMap里面可能导致->如果 target = 2*num，比如 [3,3] target=6，map 里只有一个 key=3
        // ，对应最后一次出现的下标，你会返回 [1,1]，这违反题意“不能用同一个元素两次”
        return new int[] {};
    }
}
