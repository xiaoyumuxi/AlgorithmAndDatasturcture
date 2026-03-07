package Greedy;

public class GD860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        int[] bills2 = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
        System.out.println(lemonadeChange(bills2));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                if (five < 0) {
                    return false;
                }
                ten++;
                five--;
            }
            if (bills[i] == 20) {
                if (five > 0 && ten > 0) {//两种方案，优先使用10的
                    five--;
                    ten--;
                } else if (five >= 3) {//实在没办法才用5的找零
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}
