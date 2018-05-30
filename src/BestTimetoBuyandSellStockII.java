import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/29.
 */
public class BestTimetoBuyandSellStockII {

    public static void main(String[] args){
        BestTimetoBuyandSellStockII seller = new BestTimetoBuyandSellStockII();

        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input: "+ Arrays.toString(prices) + " Result: "+seller.maxProfit(prices));

        prices = new int[]{1,2,3,4,5};
        System.out.println("Input: "+ Arrays.toString(prices) + " Result: "+seller.maxProfit(prices));

        prices = new int[]{5,4,3,2,1};
        System.out.println("Input: "+ Arrays.toString(prices) + " Result: "+seller.maxProfit(prices));
    }


    /**
     *
     * Simpler than Best Time to Buy and Sell Stock I
     * If prices[i] > prices[i-1], we will make this earning.
     *
     */

    public int maxProfit(int[] prices) {
        int res = 0;

        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > prices[i-1]) res += prices[i]-prices[i-1];
        }

        return res;
    }
}
