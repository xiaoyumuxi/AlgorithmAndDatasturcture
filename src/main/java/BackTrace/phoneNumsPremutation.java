package BackTrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneNumsPremutation {
    static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        System.out.println(backtrace("23"));
    }

    public static List<String> backtrace(String s){
        char[] ch = s.toCharArray();
        dfs(ch,0);
        return res;
    }

    static StringBuilder sb = new StringBuilder();
    static List<String> res = new ArrayList<>();

    public static void dfs(char[] ch,int level){
        if(level == ch.length){
            res.add(sb.toString());
            // 这里其实也是使用了new的复制副本的方式的，因为toString转化之后就是新的东西了
            return;
            // 这里需要return，不要因为void就忽视了return，只要不是最后return，否则都是需要写的
        }

        String a = map.get(ch[level]); // 表示当前位置可以选择的字符串
        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            dfs(ch,level+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
