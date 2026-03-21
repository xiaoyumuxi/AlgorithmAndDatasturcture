package BinarySearch;

public class FindChangePoint {
    public static void main(String[] args) {
        int[] nums = {3,4,5,0,1,2};
        System.out.println(findChangePoint(nums));
    }

    public static int findChangePoint(int[] nums){
        // 在没有顺序的数组里面需要进行二分查找
        int left = 0,right = nums.length - 1;
        while (left < right) {
            // 编码错误1: 因为下面使用了right = mid,如果三者相等就是死循环退不出来
            int mid = (right -  left) / 2 + left;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
                // 编码错误2:因为前面的是抛弃了左边的内容去右边找，但是右边的话mid本身是有可能是拐点的，因此不可以right = mid + 1
            }
        }
        return nums[right];
    }
}
