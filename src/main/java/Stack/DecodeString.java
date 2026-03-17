package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    static int i;
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        // 思路错误还是存在的，尤其是怎么去处理这个，为什么这是一个栈结构上
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        StringBuilder cur = new StringBuilder();
        int num = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = 10 * num + ch - '0';
            }else if(ch == '['){
                countStack.push(num);
                strStack.push(cur);
                num = 0;
                cur = new StringBuilder();
            }else if(ch == ']'){
                int k = countStack.pop();
                StringBuilder prev = strStack.pop();

                for(int i = 0 ; i < k ; i++){
                    prev.append(cur);
                }
                cur = prev; // 编码错误1:应该是将之前的后面跟着当前cur里面的数据重复k次，栈里面弹出的时候是存的之前的情况
            }else{
                cur.append(ch);
            }

        }

        return cur.toString();
    }

    public static String decodeString1(String s){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                i++;
            } else if (ch == '[') {
                i++;
                String inner = decodeString1(s);
                sb.append(inner.repeat(num));
                num = 0;
            } else if (ch == ']') {
                i++;
                return sb.toString();
            } else {
                sb.append(ch);
                i++;
            }
        }
        return sb.toString();
    }

}
