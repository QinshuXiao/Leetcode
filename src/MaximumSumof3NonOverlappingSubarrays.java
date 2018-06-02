/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class MaximumSumof3NonOverlappingSubarrays {

    /**
     *
     * It's a variance of Best Time to Buy and Sell Stock IV.
     * We can use the same idea to solve this problem.
     *
     * Firstly, we have an assistant array - sum.
     * sum[i] specifies the sum of array [0 ... i-1]
     *
     * DP[i][j] denotes from array [0...j-1], the maximum sum of i non-overlapping subarrays we can get.
     *
     * DP[i][j] = max(DP[i][j-1], DP[i][j-k] + sum[j] - sum[j-k])
     *
     */

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len+1];
        sum[0] = 0;
        for(int i = 0; i < len; ++i) sum[i+1] = sum[i] + nums[i];

        // dp[i][j] = max(dp[i][j-1], dp[i-1][j-k] + sum[j] - sum[j-k] )
        int[][] dp = new int[4][len+1];
        int[][] previousIndex = new int[4][len+1];

        for(int i = 1; i <= 3; ++i){
            for(int j = k; j <= len; ++j){
                if(dp[i][j-1] < dp[i-1][j-k] + sum[j]-sum[j-k]){
                    dp[i][j] = dp[i-1][j-k] + sum[j]-sum[j-k];
                    previousIndex[i][j] = j-k;
                } else {
                    dp[i][j] = dp[i][j-1];
                    previousIndex[i][j] = previousIndex[i][j-1];
                }
            }
        }

        int[] res = new int[3];
        res[2] = previousIndex[3][len];
        res[1] = previousIndex[2][res[2]];
        res[0] = previousIndex[1][res[1]];

        return res;
    }
}
