/**
 * Created by qinshuxiao on 2018/6/7.
 */
public class WildcardMatching {

    public static void main(String[] args){
        WildcardMatching matcher = new WildcardMatching();

        String s = "aa", p = "a";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "aa"; p = "a*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = ""; p = "*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "abbc"; p = "a*???";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "acdddcs"; p = "?*??*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "aajksdlajdas"; p = "a*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));
    }

    /**
     *
     * Well, if we meet wildcard / mask / regex matching problem, DP should immediately come into our mind.
     *
     * DP[i][j] should whether S[0...i-1] can be match by P[0....j-1]
     *
     * 1. If S[i] == P[j] or P[j] == '?':
     *      obviously, the result of DP[i+1][j+1] depends on the result of DP[i][j]
     * 2. If P[j] == '*':
     *      As '*' Matches any sequence of characters (including the empty sequence),
     *      the result of DP[i+1][j+1] depends on:
     *          either (1). DP[i+1][j] (match empty string, or match nothing, so depends on if S[0...i] can be match by P[0...j-1])
     *          or     (2). DP[i][j+1] (match S[i], so depends on if S[0...i-1] can be match by P[0....j])
     *
     * Therefore:
     * DP[i+1][j+1] = (P[j] == '*') && (DP[i+1][j] || DP[i][j+1])
     *              = (S[i] == P[j] || P[j] == '?') && DP[i][j]
     *
     */

    public boolean isMatch(String s, String p) {

        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[sc.length+1][pc.length+1];

        dp[0][0] = true;
        for(int j = 0; j < pc.length; ++j){
            if(pc[j] == '*') dp[0][j+1] = dp[0][j];
        }

        for(int i = 0; i < sc.length; ++i){
            dp[i+1][0] = false;
            for(int j = 0; j < pc.length; ++j){
                if(pc[j] == '*'){
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                } else {
                    dp[i+1][j+1] = (pc[j] == '?' || sc[i] == pc[j]) && dp[i][j];
                }
            }
        }

        return dp[sc.length][pc.length];
    }
}
