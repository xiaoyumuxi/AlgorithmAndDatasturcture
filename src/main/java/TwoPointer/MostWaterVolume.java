package TwoPointer;

import java.util.Scanner;

public class MostWaterVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i = 0 ; i < height.length ;i++){
            height[i] = sc.nextInt();
        }
        System.out.println(getTheVolume(height));
        sc.close();
    }

    public static int getTheVolume(int[] height){
        // 这里使用双指针的原因是因为这个动作本身模拟就是需要两个墙正好符合双指针的结构
        int i = 0,j = height.length - 1;
        int maxV = 0;
        while(i < j){
            int V = Math.min(height[i],height[j]) * (j - i);
            maxV = Math.max(maxV, V);
            // 思路问题1:不知道怎么去进行递归处理i和j->移动较短端，因为长度变小，只有短板变长才有可能逆袭
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxV;
    }
}
