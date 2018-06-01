/**
 * Created by qinshuxiao on 2018/5/31.
 */
public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

        int len = prices.length;
        int[][] dp = new int[2+1][len];

        for(int i = 0; i < len; ++i) dp[0][i] = 0;

        // dp[i][j] = max(dp[i-1][jj] + nums[j]-nums[jj]) = max(dp[i-1][jj]-nums[jj]) + nums[j]
        for(int i = 1; i <= 2; ++i){
            dp[i][0] = 0;
            int maxFirstPart = 0-prices[0];
            for(int j = 1; j < len; ++j){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+maxFirstPart);
                maxFirstPart = Math.max(maxFirstPart, dp[i-1][j]-prices[j]);
            }
        }

        return dp[2][len-1];
    }
}
