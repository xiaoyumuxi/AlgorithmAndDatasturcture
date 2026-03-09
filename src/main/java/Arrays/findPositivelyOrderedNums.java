package Arrays;

import java.util.Scanner;

public class findPositivelyOrderedNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums1 = new int[m];
        for(int i = 0; i< m ;i++){
            nums1[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] nums2 = new int[n];
        for(int i = 0; i< m ;i++){
            nums2[i] = sc.nextInt();
        }
        sc.close();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    // left/right 是要找的第几小的数
    // 奇数时 left == right，偶数时分别取左右中位数
    int left = (m + n + 1) / 2;
    int right = (m + n + 2) / 2;
    return (findKth(nums1, 0, nums2, 0, left)
          + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    // i = nums1 当前的起点（i 左边的牌都已经被"扔掉"了）
    // j = nums2 当前的起点（j 左边的牌都已经被"扔掉"了）
    // k = 还需要找第几小（每轮扔掉一半后 k 会减小）
    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 出口1：nums1 的牌全扔完了 → 答案只能在 nums2 里
        // j + k - 1 = 从 j 开始数第 k 个
        if (i >= nums1.length) return nums2[j + k - 1];
        // 出口2：nums2 的牌全扔完了 → 答案只能在 nums1 里
        if (j >= nums2.length) return nums1[i + k - 1];
        // 出口3：只找第 1 小 → 两叠最上面取小的
        if (k == 1) return Math.min(nums1[i], nums2[j]);

        // 各看第 k/2 张牌来比较
        int half = k / 2;
        // i + half - 1 = 从 i 开始数第 half 张的下标
        // 如果越界了，设为 MAX_VALUE（这叠牌不够 half 张，保护它不被扔）
        int val1 = (i + half - 1 < nums1.length)
                ? nums1[i + half - 1] : Integer.MAX_VALUE;
        int val2 = (j + half - 1 < nums2.length)
                ? nums2[j + half - 1] : Integer.MAX_VALUE;

        // 小的那边扔掉前 half 张
        if (val1 <= val2) {
            // nums1 的前 half 张扔掉 → 起点从 i 移到 i+half，k 减少 half
            return findKth(nums1, i + half, nums2, j, k - half);
        } else {
            // nums2 的前 half 张扔掉 → 起点从 j 移到 j+half，k 减少 half
            return findKth(nums1, i, nums2, j + half, k - half);
        }
    }
}
