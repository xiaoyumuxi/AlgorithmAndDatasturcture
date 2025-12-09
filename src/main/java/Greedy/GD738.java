package Greedy;

public class GD738 {
    public static void main(String[] args) {
        int n1 = 10;
        System.out.println("输入: " + n1 + " -> 输出: " + monotoneIncreasingDigits(n1)); // 应该输出 9
    }

    public static int monotoneIncreasingDigits(int n) {
        //单调递增而且最大，那么就是每一位都尽可能的大
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }//这里来确保是递增的，如果不是递增的情况，那么就需要前面一位-1,后面赋值全部都是那最大的值9
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';//赋值9
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
