package Arrays;

import java.util.Arrays;

public class findPositivelyOrderedNums {
    public static void main(String[] args) {
        
    }

    public static double findThePositivelyOrderedNums(int[] nums1,int[] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int i = (left + right)/2;
            int j = halfLen - i;
            // 这里是任何一种划分的可能，因为是两个区间，一个定好了那么另外一个也自动定好了，现在在里面找最值即可

            if( i < right && nums2[j] > nums1[i]){
                // 这个表示数组不是很合适，左边的少了
                
            }
        }
    }
}
