package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mergeInterals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        System.out.println(Arrays.deepToString(merge(nums)));
        // 编码问题5:toString仅仅可以打印一维数组内容，需要使用deepToString打印2维以上的内容

        sc.close();
    }

    public static int[][] merge(int[][] list){
        Arrays.sort(list,(o1,o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();
        // 编码问题1: 这里如果是List<List<Integer>>的话那么后面就不能加入new int[]{curL,curR}
        // 但是可以加入res.add(Arrays.asList(curL, curR));
        int curL = list[0][0], curR = list[0][1];
        for (int i = 1; i < list.length; i++) {
            // 编码问题2:这里应该是从1开始的，因为0是curL和curR的内容
            // 思路问题:卡住了，不知道怎么去进行线性扫描，这里是必须要
            if(list[i][0] > curR){
                // 区间小于list[i][0]，这里结果集就需要add了
                res.add(new int[]{curL,curR});
                // 接下来需要重置curL和curR
                curL = list[i][0];
                curR = list[i][1];
            }else{
                //反之就继续扩展当前区域，看看右边界需不需要更新
                if(curR < list[i][1]){
                    curR = list[i][1];
                }
            }
        }
        // 编码问题3:最后一个始终没有办法触发list[i][0] > curR，因此需要单独的处理add
        res.add(new int[]{curL,curR});
        // 编码问题4: return res.toArray();是转化成Object数组的，因此需要换一个API
        return res.toArray(new int[][]{});
    }
}
