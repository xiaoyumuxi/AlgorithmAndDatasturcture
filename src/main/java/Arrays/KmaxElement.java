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
        int k = sc.nextInt();
        System.out.println(getTheK(nums,k));
        sc.close();
    }
    
    public static int getTheK(int[] nums,int k){
        // 构建一个堆
        nums = heapify(nums);
        int res = 0;
        // 从堆中取出元素k次
        int heapSize = nums.length;
        for (int i = 0; i < k; i++) {
            res = popMax(nums, heapSize);
            heapSize--;
            // 编码错误4:这里调用popMax之后是需要将heapSize--的，否则就有效区间右边界就一直不变，这个元素就始终没有移除
        }
        return res;
    }

    public static int getMax(int[] nums){
        return nums[0];//大根堆堆顶元素就是最大的元素 
    }

    public static int popMax(int[] heap,int heapSize){
        //弹出最大元素
        int max = heap[0];
        // 开始堆化
        // 编码错误3: heapSize和nums.length是不一样的，往往heapSize会小一些，因此这个是需要传递进去专门维护的
        // 交换首尾元素，然后堆大小-1，因为首元素会被移除，因此没有必要交换，直接覆盖即可
        heap[0] = heap[heap.length - 1];
        down(heap, 0, heapSize - 1); 
        return max; 
    }

    public static int[] heapify(int[] nums){
        //问题1:不会手写一个堆，而且优先队列的API名字不是很记得
        // 1. 将所有的节点进行堆结构的维护
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(nums, i, size);
        }
        return nums;
    }

    public static void down(int[] nums,int parent,int heapSize){
        // 将parent和他的左右孩子进行比较，然后条件性交换
        while (true) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        // 这里是大于换位置因此就是大根堆
        if (left < heapSize && nums[left] > nums[max]) max = left;
        if (right < heapSize && nums[right] > nums[max]) max = right;
        // 编码错误1:错误的比较下标的大小了，应该是数组里面元素的大小
        if (max == parent) break;
        // 因为是从上倒下的，如果最大值已经在parent处了，那么就证明下面是已经有堆结构了的，因此就不需要在进行交换
        swap(nums, parent, max);
        // 编码错误2:down里面还是需要继续下沉的迭代到最底层(叶子节点的上一层)
        parent = max;
        }
        
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
