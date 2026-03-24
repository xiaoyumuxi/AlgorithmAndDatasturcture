import java.util.Arrays;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(find(nums, 8)));
    }

    public static int[] find(int[] nums,int target){
        // 找到最左边的target的index还有最右边的，主要是找值而且还是logN->二分查找
        // 找到左边元素的index

        // 找到右边元素的index
        
        // 合成一个数组
        return new int[]{findLeft(nums, target),findRight(nums, target)};
    }
    public static int findLeft(int[] nums,int target){
        int n = nums.length;
        int i = 0,j = n - 1;
        int res = -1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                //又错了，这个地方找到了target之后还应该尝试去继续进行向左移动
                res = mid;
                j = mid - 1;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return res;
    }

    public static int findRight(int[] nums,int target){
        int n = nums.length;
        int i = 0,j = n - 1; // 这个地方是[0,n-1]而不是其他的
        int res = -1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                res = mid;
                i = mid + 1;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return res;
    }
}
