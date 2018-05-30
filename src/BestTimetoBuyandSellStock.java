import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/29.
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args){
        BestTimetoBuyandSellStock seller = new BestTimetoBuyandSellStock();

        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input: "+ Arrays.toString(prices) + " Result: "+seller.maxProfit(prices));

        prices = new int[]{7,6,5,4};
        System.out.println("Input: "+ Arrays.toString(prices) + " Result: "+seller.maxProfit(prices));
    }

    /**
     * General form:
     * DP[i] := max( DP[j] + nums[j] - nums[i] ) where j from 0 to i
     *
     * Simplified dp solution, don't need a array, as only one transaction is allowed.
     * Or we can think in another aspect:
     * (nums[i] - nums[i-1]) gives us difference between consecutive two days' prices.
     * And we use a variable, named sum, to sum them up.
     * If sum + (nums[i] - nums[i-1]) > 0, we add it, and possibly update our result.
     * But when sum < 0, we reset it to 0.
     *
     * The logic behind is that:
     * We will always buy stocks at its relatively lowest point.
     *
     */

    public int maxProfit(int[] prices) {
        int sum = 0, res = 0;

        for(int i = 1; i < prices.length; ++i){
            if(sum < prices[i-1]-prices[i]) {
                sum = 0;
            } else {
                sum += prices[i]-prices[i-1];
                res = Math.max(sum,res);
            }
        }

        return res;
    }
}
