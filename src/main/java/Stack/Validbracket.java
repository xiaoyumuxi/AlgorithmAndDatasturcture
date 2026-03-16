package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Validbracket {
    public static void main(String[] args) {
        System.out.println(isBracket("((]]]"));
        System.out.println(isBracket("()[]{}"));
    }

    public static boolean isBracket(String s){
        char[] ch = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0 ; i < ch.length ; i++){
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '['){
                // 左括号无脑入栈
                stack.add(ch[i]);
            }else{
                // 右括号需要进行尝试匹配
                if (stack.isEmpty()) return false;

                if (ch[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (ch[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (ch[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
                // 编码错误1:判断相等了之后没有进行弹出导致后面一直就锁死判断一直失败，而且缺少了一个栈为空也失败的场景
            }
        }
        return true;
    }
}
