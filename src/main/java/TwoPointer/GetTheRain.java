package TwoPointer;

import java.util.Scanner;

public class GetTheRain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        str = str.substring(1, str.length() - 1);
        String[] parts = str.split(",");

        int[] height = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            height[i] = Integer.parseInt(parts[i].trim());
        }
        System.out.println(trap(height));
        System.out.println(trap1(height));
    }

    public static int trap1(int[] height) {
        // 目的是记录每一个位置左侧和右侧最高的柱子
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length ;i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            // 编码错误1:在这里求左侧最大数组里面没有直接利用到数组本身的含义进行处理，然后后面自己处理的时候又频繁出错
        }
        int[] rightMax = new int[height.length];
        rightMax[height.length -1] = height[height.length - 1];
        for(int i = height.length - 1; i >0 ; i--){
            rightMax[i - 1] = Math.max(rightMax[i], height[i - 1]);
            // 编码错误3:这里的计算rightMax[i-1]用的是 height[i] 但是实际应该是 height[i - 1]
        }
        int res = 0;
        for(int i = 0; i < height.length ; i++){
            res +=Math.min(leftMax[i], rightMax[i])- height[i];
            // 编码错误2:水位的意思是需要减去里面的柱子的高度的height[i]的
        }
        // 思路卡住了，突然忘记求这两个数组的意义是求出每一列最大容积
        return res;
    }

    public static int trap(int[] height){
        // 使用标准的双指针来尝试一下
        int left = 0,right = height.length - 1;
        int leftMax = 0,rightMax = 0;
        int res = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                // 编码错误1: 因为这里前面的height[left] < height[right]已经限定好了左侧是短板，因此直接取
                // letfMax即可不需要去Math.min(leftMax,rightMax)的
                left ++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right --;
            }
        }
        return res;
    }
}
