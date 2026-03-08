package Arrays;

import java.util.Scanner;

public class findTheSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
    }
    
    public static int find(int[] nums){
        for(int i = 0; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] == nums[j])return nums[i];
            }
        }
        return -1;
    }// O(N^2)复杂度，有点高了需要进行优化


}
