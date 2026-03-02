public class BuyTicket2 {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(getMaxProf(prices));
    }

    public static int getMaxProf(int[] prices) {
        int[] prof = new int[prices.length];
        prof[0] = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            prof[i] = prices[i] - prices[i - 1];
            if (prof[i] > 0) res += prof[i];
        }
        return res;
    }
}
