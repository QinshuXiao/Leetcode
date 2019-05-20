class Solution {
   /*
    * DP[i][j] represents the edit distance between word1[0...i) and word2[0...j)
    * So:
    * if word1[i] == word[j]:
    *   DP[i+1][j+1] = dp[i][j] (no edit needed)
    * else:
        DP[i+1][j+1] = Min(
            DP[i+1][j] + 1, //insert word2[j] into word1
            DP[i][j+1] + 1, //delete word1[i] from word1
            DP[i][j] + 1 //replace word1[i] with word2[j]
        )
    */
    public int minDistance(String word1, String word2) {
        if(word1 == word2)
            return 0;
        else if(word1.length() == 0)
            return word2.length();
        else if(word2.length() == 0)
            return word1.length();
        
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row+1][col+1];
        
        dp[0][0] = 0;
        for(int i = 1; i <= row; ++i){
            dp[i][0] = i;
            for(int j = 1; j <= col; ++j){
                dp[0][j] = j;
                
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],
                        Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        
        return dp[row][col];
    }
    
}