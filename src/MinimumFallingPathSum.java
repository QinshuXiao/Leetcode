class Solution {
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] dp = new int[cols];
        
        for(int j = 0; j < A[0].length; ++j){
            dp[j] = A[0][j];
        }
        
        for(int i = 1; i < rows; ++i){
            int[] next = new int[cols];
            for(int j = 0; j < cols; ++j){
                int minVal = dp[j];
                if(j-1 >= 0)
                    minVal = Math.min(minVal, dp[j-1]);
                if(j+1 < A[i].length)
                    minVal = Math.min(minVal, dp[j+1]);
                
                next[j] = minVal+A[i][j];
            }
            dp = next;
        }
        
        int res = dp[0];
        for(int j = 0; j < cols; ++j){
            res = Math.min(res, dp[j]);
        }
        
        return res;
    }
}