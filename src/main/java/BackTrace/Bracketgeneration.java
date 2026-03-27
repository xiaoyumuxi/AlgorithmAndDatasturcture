package BackTrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Bracketgeneration {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }

    public static List<String> generate(int n){
        dfs(n, 0, 0);
        return res;
    }

    static StringBuilder sb = new StringBuilder();
    static List<String> res = new ArrayList<>();

    public static void dfs(int n,int left,int right){
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append("(");
            dfs(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(right < left){
            sb.append(")");
            dfs(n, left , right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // 编码错误1:这里没有剪枝导致一直递归下去没有办法回来了，少了两个if条件
    }

    public static boolean isVaild(String s){
        // 判断括号是否有效
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')stack.push(s.charAt(i));
            if(s.charAt(i) == ')'){
                if (stack.isEmpty()) return false; 
                stack.pop();
                // 编码错误3:因为只有()两种不是而前面都抵消了，因此我们只需要判断stack非空即可，不需要peek出左括号来抵消
            }
        }
        return false;
    }// 编码错误2:这个判断括号是否有效没有用，因为两个剪枝的if已经确保了生成的一定是合法的(只要是左括号在右括号前即可)
}
