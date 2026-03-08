package Arrays;

import java.util.Scanner;

public class KmaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(getTheK(nums));
        sc.close();
    }
    
    public static int getTheK(int[] nums){
        // 构建一个堆
        int[] heap = heapify(nums);
        // 从堆中取出元素k次

    }

    public static int getMax(int[] nums){
        int i = nums[0];//大根堆堆顶元素就是最大的元素
        
    }

    public static int[] heapify(int[] nums){
        //问题1:不会手写一个堆，而且优先队列的API名字不是很记得
        // 1. 将所有的节点进行堆结构的维护
        int size = nums.length;
        for(int i = size / 2 - 1; i >= 0 ; i--){
            down(nums, i);
        }
        return nums;
    }

    public static void down(int[] nums,int parent){
        // 将parent和他的左右孩子进行比较，然后条件性交换
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int max = nums[parent];
        // 这里是大于换位置因此就是大根堆
        if(nums[left] > max)swap(nums,parent,left);
        if(nums[right] > max)swap(nums,parent,right);
        // 编码错误1:错误的比较下标的大小了，应该是数组里面元素的大小
        
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}
