package BackTrace;

import java.util.ArrayList;
import java.util.List;

public class BT17 {
    final String letterMap[] = {
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    public static void main(String[] args) {
        BT17 solution = new BT17();

        // 测试案例 1: "23" -> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations("23"));

        // 测试案例 2: "" -> []
        System.out.println(solution.letterCombinations(""));
    }

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public void backTrace(String target, int index) {
        if (index == target.length()) {
            res.add(path.toString());
            return;
        }

        int a = (int) target.charAt(index) - '2';//获取对应index的字符
        //去letter数组里面找
        String letter = letterMap[a];//将def这种string提取出来
        for (int i = 0; i < letter.length(); i++) {//然后去这种string里面选一个
            path.append(letter.charAt(i));//选一个
            backTrace(target, index + 1);//去获取下一个string
            path.deleteCharAt(path.length() - 1);//回溯
        }

    }

    public List<String> letterCombinations(String digits) {
        res.clear();
        path.setLength(0); // 清空 StringBuilder

        if (digits == null || digits.isEmpty()) {
            //如果不加 if (digits.length() == 0) 的判断，直接调用 backTrace 会在 res 里加入一个空字符串 [""]，但题目通常要求返回空列表 []
            return res;
        }

        backTrace(digits, 0);
        return res;
    }
}
