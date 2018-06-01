import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/31.
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public static void main(String[] args){
        BestTimetoBuyandSellStockwithCooldown seller = new BestTimetoBuyandSellStockwithCooldown();

        int[] prices = new int[]{1,2,3,0,2};
        System.out.println("Prices: "+ Arrays.toString(prices)+" Result: "+seller.maxProfit(prices));
    }

    /**
     *
     * Well, still in a DP way.
     * But note that we have a cooldown requirement.
     * So the DP equation changes to:
     * DP[i] = max(DP[i-1], max(DP[ii-2]+prices[i]-prices[ii]) )
     *       = max(DP[i-1], max(DP[ii-2]-prices[ii]) + prices[i] )
     *       = max(DP[i-1], maxFirstPart+prices[i])
     *                      where maxFirstPart = max(DP[ii-2]-prices[ii]), 2 <= ii < i
     *
     */

    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = prices[1] > prices[0]?prices[1]-prices[0]:0;
        int maxFirstPart = Math.max(-prices[0],-prices[1]);

        //dp[i] = max(dp[i-1], max(dp[jj-2] + prices[i] - prices[jj]));
        for(int i = 2; i < len; ++i){
            dp[i] = Math.max(dp[i-1], prices[i] + maxFirstPart);
            maxFirstPart = Math.max(maxFirstPart, dp[i-2]-prices[i]);
        }

        return dp[len-1];
    }
}
