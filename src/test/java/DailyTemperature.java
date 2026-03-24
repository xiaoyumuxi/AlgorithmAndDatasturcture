import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperature {
    // 首先是怎么看出来需要这个单调队列的呢，这个是需要进行复习的
    
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(DailyTem(temperatures)));
    }

    public static int[] DailyTem(int[] temperatures){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 一个元素入栈将将更小的元素全部弹出来
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                // 复习的时候这个地方少了!stack.isEmpty()
                res[stack.peek()] = i - stack.peek();
                stack.pop();
                // 因为找到了更大的元素，所以这个时候还需要记录对应的天数
            }
            stack.push(i);
        }

        return res;
    }
}
