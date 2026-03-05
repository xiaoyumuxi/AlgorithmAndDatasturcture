import java.util.Arrays;
import java.util.Scanner;

public class MoveZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        } //忘记需要读取数据了hhh

        System.out.println(Arrays.toString(getZeroNums(nums)));
        sc.close();
    }

    public static int[] getZeroNums(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
