/**
 * Created by qinshuxiao on 2018/6/7.
 */
public class RegularExpressionMatching {

    public static void main(String[] args){
        RegularExpressionMatching matcher = new RegularExpressionMatching();

        String s = "aa", p = "a";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "aa"; p = "a*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "ab"; p = ".*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = ""; p = ".*c*b*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = ""; p = ".*c*b";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "abc"; p = ".*a*b*c*.*";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));

        s = "mississippi"; p = "mis*is*p*.";
        System.out.println("S: "+s+" P: "+p+ "    Result:"+matcher.isMatch(s,p));
    }

    /**
     *
     * As I said before,
     * if we meet wildcard / mask / regex matching problem, DP should immediately come into our mind.
     *
     * DP[i][j] should whether S[0...i-1] can be match by P[0....j-1]
     *
     * 1. If S[i] == P[j] or P[j] == '.':
     *      obviously, the result of DP[i+1][j+1] depends on the result of DP[i][j]
     * 2. If P[j] == '*':
     *      As '*' Matches any sequence of characters (including the empty sequence),
     *      the result of DP[i+1][j+1] depends on:
     *          either (1). DP[i+1][j-1]
     *                      (Not match S[i], or match ZERO S[i], so depends on if S[0...i] can be match by P[0...j-2])
     *          or     (2). (S[i] == P[j-1] || P[j-1] == '.') && DP[i][j+1]
     *                      (match ONE S[i], so depends on if S[0...i-1] can be match by P[0....j])
     *
     * Therefore:
     * DP[i+1][j+1] = (P[j] == '*') && ( DP[i+1][j-1] ||  ((S[i] == P[j-1] || P[j-1] == '.') && DP[i][j+1])  )
     *              = (S[i] == P[j] || P[j] == '.') && DP[i][j]
     *
     */

    public boolean isMatch(String s, String p) {
        if(s == p) return true;
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[sc.length+1][pc.length+1];

        dp[0][0] = true;
        for(int j = 0; j < pc.length; ++j){
            if(pc[j] == '*') dp[0][j+1] = dp[0][j-1];
            else dp[0][j+1] = false;
        }

        for(int i = 0; i < sc.length; ++i){
            dp[i+1][0] = false;
            for(int j = 0; j < pc.length; ++j){
                if(pc[j] == '*' ){
                    dp[i+1][j+1] = ((pc[j-1] == sc[i] || pc[j-1] == '.') && dp[i][j+1]) || dp[i+1][j-1];
                } else{
                    dp[i+1][j+1] = (sc[i] == pc[j] || pc[j] == '.') && dp[i][j];
                }
            }
        }

        return dp[sc.length][pc.length];
    }
}
