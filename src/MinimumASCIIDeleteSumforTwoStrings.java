class Solution {

    /*
     * DP[i][j] represents the minimumDeleteSum from s1[0...i) to s2[0...j)
     * if s1[i] == s2[j]:
     *   DP[i+1][j+1] = DP[i][j] (no deletion needed)
     * else:
     *   DP[i+1][j+1] = Min(
     *      DP[i][j+1] + s1[i], // delete s1[i] from s1
     *      DP[i+1][j] + s2[j]  // delete s2[j] from s2
     * )  
     */
    public int minimumDeleteSum(String s1, String s2) {
        if(s1 == s2)
            return 0;
        
        int row = s1.length();
        int col = s2.length();
        
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        int[][] dp = new int[row+1][col+1];
        dp[0][0] = 0;
        
        for(int i = 1; i <= row; ++i){
            dp[i][0] = dp[i-1][0] + (int)sc1[i-1];
            for(int j = 1; j <= col; ++j){
                dp[0][j] = dp[0][j-1] + (int)sc2[j-1];
                if(sc1[i-1] == sc2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j]+(int)sc1[i-1],
                                       dp[i][j-1]+(int)sc2[j-1]);
                }
            }
        }
        
        return dp[row][col];
    }
}