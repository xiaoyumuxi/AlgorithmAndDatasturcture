package MovingWindows;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NoRepeatedLongestSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int len = 0;
        for(int j = 0; j < ch.length ; j++){
            while(set.contains(ch[j])){
                set.remove(ch[i]);
                i++;
            }
            set.add(ch[j]);
            len = Math.max(len,j-i+1);
        }
        return len;
    }

}
