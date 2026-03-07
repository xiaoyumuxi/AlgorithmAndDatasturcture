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
            map.put(nums[i], i);
        }

        for (int num : map.keySet()) {
            if (map.containsKey(target - num)) {
                return new int[] { map.get(num), map.get(target - num) };
            }
        }
        return new int[] {};
    }
}
