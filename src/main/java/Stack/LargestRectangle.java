package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int curHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                // 思路错误1:弹出的时候底下的宽度是受限于左边最矮的柱子的，因此长度就不是i+1,左侧最矮就是这样获得的
                // 编码错误2:因为如果栈里面，没有元素的时候peek的结果是空，因此这里需要手动判空处理一下(主要是前面的peek后有了一个pop)
                int width = i - left - 1;
                int area = heights[mid] * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
            // 编码错误1:需要将当前元素压栈，千万不要忘记了
        }

        return maxArea;
    }
}