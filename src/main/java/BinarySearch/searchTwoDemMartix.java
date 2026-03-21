package BinarySearch;

public class searchTwoDemMartix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(find(matrix, 13));
    }

    public static boolean find(int[][] nums,int target){
        // 首先可以使用二分大概确认行的位置
        int n = nums[0].length - 1;
        // 编码错误1:n表示错了不应该是nums.length - 1，这个是行数-1
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 编码错误2:这个求mid的步骤操作是有问题的，主要是有溢出风险如果使用(left + right)/2的方式的话
            if(nums[mid][0] > target){
                right = mid - 1;                
            }else if(nums[mid][0] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }

        if (right < 0) return false;
        // 编码错误3:因为下面使用了right，因此这里需要确保right的边界，也就是>=0

        // 思路错误1:这个时候我们是需要和targt在一行的元素，根据性质其实就是小于target的最近元素->right的值

        int i = 0,j = n;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[right][mid] > target){
                j = mid - 1;
            }else if(nums[right][mid] < target){
                i = mid + 1;
            }else{
                return true;
            }
        }
        return false;

    }

    public static boolean search(int[][] nums,int target){
        int n = nums[0].length,m = nums.length;
        int i = 0, j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid/n][mid%n] > target){
                j = mid - 1;
            }else if(nums[mid/n][mid%n] < target){
                i = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
