/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class DecodeWays {

    public static void main(String[] args){
        DecodeWays runner = new DecodeWays();

        String s = "12123";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "12";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "26";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "28";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "10";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "20";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "0";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "130";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));

        s = "120012";
        System.out.println("Input: "+s+" Result: "+runner.numDecodings(s));
    }


    /**
     *
     * Well, for those kind of question asking us give possibilities of number of combinations based on some logic on array.
     * Dynamic Programming should come into our mind!
     *
     * The dp equation is obvious.
     * DP[i] denotes ways we can have to decode string from [0 to i-1]
     *
     * There are some situations:
     * (1). DP[i+1] = DP[i-1] + DP[i] if s[i-1] == '1'
     *      If your previous character is '1', which leads two ways:
     *          I. one is that we can combine current character and previous '1', generating a number from '10' to '19', all of them are valid.
     *          II. The other is that we consider them as separate part, "1" and "s[i]"
     *      So we need to take both two situations into accounts. Thus we sum them up.
     *
     * (2). DP[i+1] = DP[i-1] + DP[i] if s[i-1] == '2' AND s[i] is between '0' to '6'
     *      Almost like the situation (1), the only deference is that number from '20' to '26' is valid, but it isn't for the numbers '27' to '29'
     *
     * (3). Other situation: DP[i+1]] = DP[i]
     *
     *
     * It seems like we have made it here. But Actually there are one more edge cases we haven't notice yet.
     * That is '0' !
     * '0' is very special, it's valid only when it follows '1' or '2' !
     * For example, '10' and '20' is valid, but '00', '0', '30', '03', all of them are invalid!
     * And for '10' and '20', there are only one way to decode, as '0' cannot be valid alone.
     * So our equation should be modified to deal with '0'
     *
     * DP[i+1] = DP[i-1] + DP[i] if s[i-1] == '1' and s[i] != '0'
     *         = DP[i-1] if s[i-1] == '1' and s[i] == '0'
     *         = DP[i-1] + DP[i] if s[i-1] == '2' and s[i] - '0' > 0 AND s[i] - '0' <= 0
     *         = DP[i-1] if s[i-1] == '2' and s[i] == '0'
     *         = DP[i] else if s[i] != '0'
     *         = 0 otherwise directly return
     *
     */

    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.startsWith("0")) return 0;

        char[] sc = s.toCharArray();
        int len = sc.length;
        int[] dp = new int[len+1];
        dp[0] = dp[1] = 1;

        for(int i = 1; i < len; ++i){
            if(sc[i-1] == '1'){
                if(sc[i] == '0') dp[i+1] = dp[i-1];
                else dp[i+1] = dp[i-1]+dp[i];
            } else if(sc[i-1] == '2' && sc[i] - '0' <= 6) {
                if(sc[i] == '0') dp[i+1] = dp[i-1];
                else dp[i+1] = dp[i-1]+dp[i];
            } else {
                if(sc[i] == '0') return 0;

                dp[i+1] = dp[i];
            }
        }

        return dp[len];
    }
}
