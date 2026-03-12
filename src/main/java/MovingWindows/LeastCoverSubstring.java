package MovingWindows;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeastCoverSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
        sc.close();
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0,right = 0;
        int valid = 0; // 表示已经达到所需要的数量的字符个数
        int len = Integer.MAX_VALUE;
        int start = 0;
        // 1.自动扩张右窗口j
        while(right <s.length()){
            // 如果这个字符是 need 里的，就更新 window            
            char c = s.charAt(right);
            right++;
            // 编码错误1:右窗口一直没有动导致最后函数卡死
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 2.达到所需要的个数之后才开始尝试缩减window
            while (valid == need.size()) {
                // 更新最小长度
                if(right - left < len){
                    len = right - left;
                    start = left;
                } // 因为双指针left和right一直在移动，因此需要start和len来求substring

                char d = s.charAt(left);
                left++;

                // 缩减window，但是因为需要保证valid == need.size()因此这里不用担心会被卡
                if(need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
            

            
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);//因为substring左闭右开因此不用-1

    }

    
}
