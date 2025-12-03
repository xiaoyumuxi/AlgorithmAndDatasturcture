package Greedy;

//买卖股票最佳时机
public class GD122 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,10,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length - 1; i++){
            int diff = prices[i+1] - prices[i];
            if(diff > 0){
                max += diff;
            }
        }
        return max;
    }
}
