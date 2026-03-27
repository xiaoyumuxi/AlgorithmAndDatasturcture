package BackTrace;

import java.util.ArrayList;
import java.util.List;

public class SplitPalindromeStr {
    public static void main(String[] args) {
        System.out.println(spilt("aab"));
    }

    public static List<List<String>> spilt(String s) {
        dfs(s, 0);
        return res;
    }

    public static List<List<String>> res = new ArrayList<>();
    public static List<String> path = new ArrayList<>();

    public static void dfs(String s, int index) {
        // index 处切 or 不切两种方案
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i < s.length();i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                // 编码错误1:这里爆栈了因为切分不具体
                path.remove(path.size() - 1);
            }
        }

    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}
