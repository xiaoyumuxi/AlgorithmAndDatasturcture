package TwoPointer;

import java.util.Scanner;

public class LongestPalindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getTheString(sc.next()));
        sc.close();
    }

    public static String getTheString(String str){
        char[] ch = str.toCharArray();
        String substring = "";
        for(int i = 0 ; i < ch.length;i++){
            String a = expandAroundCenter(str, i, i);
            String b = expandAroundCenter(str, i, i+1);
            if(Math.max(a.length(),b.length()) > substring.length()){
                if(a.length() > b.length())substring = a;
                else substring = b;
            }
        }
        return substring;
    }

    public static String expandAroundCenter(String s,int left, int right){
        char[] ch = s.toCharArray();
        while(left >= 0 && right < ch.length && ch[left] == ch[right]){
            left--;
            right++;
            // 编码错误1:return s.substring(left, right) 放在了循环体内，意味着第一次匹配就直接返回了
        }
        return s.substring(left+1,right);
        // 编码错误2:这里的退出时left的最小值是-1,因此就可能出现越界的现象，因此必须要left+1来取
        // Java 的 substring(start, end) 是左闭右开 [start, end)，因此才需要这样处理
    }
}