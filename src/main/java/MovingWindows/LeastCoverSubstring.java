package MovingWindows;

public class LeastCoverSubstring {
    public static void main(String[] args) {
        
    }

    public String minWindow(String s, String t) {
        int[] set = new int[26];
        char[] ch = t.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            set[ch[i]-'A']++;
        }
        // 这个set类似哈希表，现在需要str里面的字频统计起码都大于这里面的数才可以的
        int i = 0;
        for(int j = 0 ; j < s.length() ; j++){
            String str = s.substring(i,j+1);
            // 将滑动窗口的步骤和判断
        }
    }

    public static boolean is(String str ,int[] set){
        char[] ch = str.toCharArray();
        int[] set1 = new int[26];
        for (int i = 0; i < ch.length; i++) {
            set1[ch[i]-'A']++;
        }
        for (int i = 0; i < set1.length; i++) {
        }
    }
}
