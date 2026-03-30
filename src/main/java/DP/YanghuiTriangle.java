package DP;

import java.util.ArrayList;
import java.util.List;

public class YanghuiTriangle {
    public static void main(String[] args) {
        System.out.println(buildTriangle(5));
    }

    public static List<List<Integer>> buildTriangle(int numRows){
        List<List<Integer>> res = new ArrayList<>(numRows);
        for(int r = 0 ; r < numRows ; r++){ // 从0开始编号行数
            List<Integer> row = new ArrayList<>(r+1);
            row.add(1); // 0 -> 1
            for(int i = 1 ; i < r ; i++){
                int x = res.get(r-1).get(i-1) +res.get(r-1).get(i);
                row.add(x);
            }
            // 编码错误1:因为这里首尾的1处理的逻辑如果统一的话那么需要引入额外的默认的0,但是这个是不方便不好处理的，因此这里选择只计算非1部分的值而不是统一逻辑
            if(r >= 1)row.add(1);
            res.add(row);
        }
        return res;
    }
}
