package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Dailytemperature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length ; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 编码错误1:存的是index不是温度，因此不是stack.peek()
                int prev = stack.pop();
                answer[prev] = i - prev;
                // 思路问题1:表示第prev天在这个时候终于被弹出来了，因为找到了更大的数
                }
            stack.push(i);
        }

        return answer;
    }


}
