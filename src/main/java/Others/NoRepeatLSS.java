package Others;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NoRepeatLSS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getLenOfLSS(s));
        sc.close();
    }

    public static int getLenOfLSS(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < ch.length; j++) {
            while (set.contains(ch[j])) {
                set.remove(ch[i]);
                i++;
            }
            set.add(ch[j]);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
