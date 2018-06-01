import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/31.
 */
public class BestTimetoBuyandSellStockIV {

    public static void main(String[] args){
        BestTimetoBuyandSellStockIV seller = new BestTimetoBuyandSellStockIV();

        int k = 2;
        int[] prices = {2,4,1};
        System.out.println("Input: "+ Arrays.toString(prices)+" k="+k+"  Result: "+seller.maxProfit(k, prices));

        prices = new int[]{3,2,6,5,0,3};
        System.out.println("Input: "+ Arrays.toString(prices)+" k="+k+"  Result: "+seller.maxProfit(k, prices));

        k = 0;
        System.out.println("Input: "+ Arrays.toString(prices)+" k="+k+"  Result: "+seller.maxProfit(k, prices));

        k = 3;
        prices = new int[]{};
        System.out.println("Input: "+ Arrays.toString(prices)+" k="+k+"  Result: "+seller.maxProfit(k, prices));

        k = 100000;
        prices = new int[]{5,2,3,1,2,4,2,1,4,1,7,8,2,2,2,22,3,1,44,22,1,31,2,4,14,3};
        System.out.println("Input: "+ Arrays.toString(prices)+" k="+k+"  Result: "+seller.maxProfit(k, prices));
    }

    /**
     *
     * DP[i][j] = max( dp[i][j-1], max(dp[i][jj] + prices[j] -prices[jj]) )
     *          = max(dp[i][j-1], max(dp[i][jj] - prices[jj]) + prices[j] )
     *          = max(dp[i][j-1], maxFirstPart + prices[j]) where maxFirstPart = max(dp[i][jj] - prices[jj]) where 0 <= jj < j
     *
     * And as dp[i][j] is only depended on dp[i-1][jj] and dp[i][j-1], we can elaborate our dp solution, replacing the 2D array with the 1D array
     *
     * In addition, when K > prices.length/2, the problem becomes BestTimetoBuyandSellStockII, because you can at most finish prices.length/2 transanctions.
     *
     */

    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) return 0;

        int len = prices.length;
        //k = Math.min(k, len/2);
        if(k >= len / 2){
            int res = 0;
            for(int i = 1; i < len; ++i){
                if(prices[i] > prices[i-1]){
                    res += prices[i] - prices[i-1];
                }
            }

            return res;
        }

        int[] dp = new int[len];
        for(int i = 0; i < len; ++i) dp[i] = 0;

        for(int i = 1; i <= k; ++i){
            int maxFirstPart = dp[0] - prices[0];
            dp[0] = 0;

            for(int j = 1; j < len; ++j){
                int oldDPj = dp[j];
                dp[j] = Math.max(dp[j-1], prices[j]+maxFirstPart);
                maxFirstPart = Math.max(maxFirstPart, oldDPj-prices[j]);
            }
        }

        return dp[len-1];
    }
}
