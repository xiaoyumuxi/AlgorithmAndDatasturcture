import java.util.HashSet;
import java.util.Set;

public class LSS {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] ch = s.toCharArray();
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int j = 0, i = 0; j < ch.length; j++) {
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
