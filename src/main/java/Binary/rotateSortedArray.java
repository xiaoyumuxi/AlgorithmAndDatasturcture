package Binary;

public class rotateSortedArray {
    public static void main(String[] args) {
        int[] n = {4,5,6,7,0,1,2};
        System.out.println(find(n, 0));
        System.out.println(find(n, 3));
    }

    public static int find(int[] nums,int target){
        int k = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]){
                k = i + 1;
                break;
            }
        }
        if (k == -1) return BinarySearch(nums, 0, nums.length - 1, target);
        // 编码错误1:没有考虑原本数组就是有序的情况，k没有变->原本就有序
        int left = BinarySearch(nums, 0, k, target);
        int right = BinarySearch(nums, k, nums.length - 1, target);
        return left + right == -2 ? -1 : Math.max(left, right);
    }

    public static int BinarySearch(int[] nums,int i,int j,int target){
        while (i <= j) {
            int mid = (i + j) / 2;
            if(target > nums[mid]){
                i = mid + 1;
            }else if(target < nums[mid]){
                j = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
