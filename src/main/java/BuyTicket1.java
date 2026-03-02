public class BuyTicket1 {

    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(getMaxProf(nums));
    }

    public static int getMaxProf(int[] nums) {
        int maxProf = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
            } else {
                maxProf = Math.max(maxProf, nums[i] - minPrice);
            }
        }

        return maxProf;
    }
}
