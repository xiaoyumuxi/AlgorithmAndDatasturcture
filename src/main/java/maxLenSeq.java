public class maxLenSeq {

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] tails = new int[nums.length];
        int size = 0; // size 代表 tails 数组目前的有效长度

        for (int num : nums) {
            // 在 tails 的 [0, size) 区间内进行二分查找
            int i = 0,
                j = size;
            while (i < j) {
                int mid = i + (j - i) / 2;
                // 我们要在 tails 里找第一个 >= num 的数
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            // i 就是 num 应该放置的位置
            tails[i] = num;

            // 如果 i 等于 size，说明 num 比 tails 里所有的数都大，长度增加
            if (i == size) size++;
        }

        return size;
    }
}
