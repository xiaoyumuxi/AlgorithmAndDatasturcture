package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.deepToString(Anagrams(str)));
    }

    public static String[][] Anagrams(String[] str){
        Map<String,List<String>> map = new HashMap<>();
        for(String s : str){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            // 编码错误2:将字符数组转化成String不可以使用String s1 = arr.toString();因为这个其实是打印char[]数组的地址
            String s1 = new String(arr);
            if(map.containsKey(s1)){
                map.get(s1).add(s);
                // 编码错误1:map.put(s1, map.get(s1).add(s));这里面的后部分返回的是一个布尔值，因此不可以插入
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s1, list);
            }
        }

        String[][] result = new String[map.size()][];
        int i = 0;
        for (List<String> group : map.values()) {
            result[i++] = group.toArray(new String[0]);
        }
        return result;
    }
}
