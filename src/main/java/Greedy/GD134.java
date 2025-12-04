package Greedy;

public class GD134 {
    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] rest = new int[len];
        for (int i = 0; i < len; i++) {
            rest[i] = gas[i] - cost[i];
        }
        int Allsum = 0;
        int index = -1;
        for (int i = 0; i < len; i++) {
            Allsum += rest[i];
        }
        if (Allsum >= 0) {
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += rest[i];
                if (sum < 0) {
                    index = i + 1;
                    break;
                }
            }
        }
        //这个时候就是负数区域，那么直接从这里的
        return index;
    }
}
