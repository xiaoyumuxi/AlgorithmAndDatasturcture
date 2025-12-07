package Greedy;

import java.util.List;

public class GD376 {
    public static void main(String[] args) {

    }

    //传入一个数组，返回摆动序列的最大长度
    public Integer howLong(List<Integer> num) {
        //有平的节点都要删去
        int count = 0;
        for (int i = 1; i < num.size() - 1; i++) {
            int prediff = num.get(i) - num.get(i - 1);
            int curdiff = num.get(i + 1) - num.get(i);

            if ((prediff <= 0 && curdiff > 0) ||(prediff >= 0 && curdiff < 0)) {
                count++;
            }

        }


        return 0;
    }
}
