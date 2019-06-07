class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        
        for(String word : wordDict)
            set.add(word);
        
        // DP[i] stores all index j such that s.substring(j,i) exists in wordDict
        List<Integer>[] dp = new ArrayList[s.length()+1];
        for(int i = 0; i < dp.length; ++i)
            dp[i] = new ArrayList<Integer>();
        dp[0].add(0);
        
        for(int i = 1; i <= s.length(); ++i){
            for(int j = i-1; j >= 0; --j){
                if(dp[j].size()>0 && set.contains(s.substring(j, i))){
                    dp[i].add(j);
                }
            }
        }
        
        List<String> res = new ArrayList<String>();
        generateStrs(dp, s.length(), res, "", s);
        
        return res;
    }
    
    // DFS to generate result strings
    private void generateStrs(List<Integer>[] dp, int idx, List<String> res, String str, String s){
        if(idx == 0){
            // remove the trailing space
            res.add(str.trim());
            return;
        }
        
        for(int prevIdx : dp[idx]){
            
            generateStrs(dp, prevIdx, res, s.substring(prevIdx,idx)+" "+str, s);
        }
    }
}