package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G110 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // 1. 处理输入
            int n = sc.nextInt();
            String beginStr = sc.next();
            String endStr = sc.next();

            // 使用 Set 作为字典，查询速度 O(1)
            HashSet<String> dict = new HashSet<>();
            for (int i = 0; i < n; i++) {
                dict.add(sc.next());
            }

            // 2. 调用 BFS 方法获取结果
            int result = bfs(beginStr, endStr, dict);

            // 3. 输出
            System.out.println(result);
        }
    }


    public static int bfs(String start, String end, HashSet<String> dict) {
        if (start.equals(end)) return 1;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();//记录已经访问过的路径，hashset去重

        queue.offer(start);
        visited.add(start);

        int step = 1; // 路径长度，起点算 1

        while (!queue.isEmpty()) {
            // size 记录当前这一层有多少个节点
            // 这是“按层遍历”的关键，保证了我们是一圈一圈往外扩的
            int size = queue.size();

            // 遍历当前层的所有单词
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();

                // 尝试变换每一个字符
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j]; // 备份

                    // 尝试 a-z 替换
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        charArray[j] = c;
                        String nextWord = new String(charArray);

                        // 1. 找到了终点
                        if (nextWord.equals(end)) {
                            return step + 1;
                        }

                        // 2. 如果字典里有，且没走过，加入下一层队列
                        if (dict.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    charArray[j] = originalChar; // 还原，准备变下一个位置
                }
            }
            // 这一层全部走完了，步数 +1，进入下一层
            step++;
        }

        return 0; // 队列走空了也没找到
    }
}

