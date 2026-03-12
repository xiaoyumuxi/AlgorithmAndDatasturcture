package MovingWindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(findAnagrams(s, p));
        sc.close();
    }

    public static List<Integer> findAnagrams(String s,String p){
        List<Integer> result = new ArrayList<>();

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }// 刚开始的窗口需要进行一次比较

        for(int i = p.length(); i < s.length() ; i++){
            //i是右指针，先构建一个p大小的窗口
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
            // 先移动再比较，如果合适就加入进去
        }

        return result;

    }
}
