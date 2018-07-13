import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qinshuxiao on 2018/7/12.
 */
public class WordBreak {

    public static void main(String[] args){
        WordBreak wb = new WordBreak();

        String s = "leetcode";
        String[] words = new String[]{"leet","code"};
        System.out.println("S: "+s+ "  Dict:"+ Arrays.toString(words));
        System.out.println("Can Break? "+wb.wordBreak(s, Arrays.asList(words)));
        System.out.println("================================");

        s = "applepenapple";
        words = new String[]{"apple", "pen"};
        System.out.println("S: "+s+ "  Dict:"+ Arrays.toString(words));
        System.out.println("Can Break? "+wb.wordBreak(s, Arrays.asList(words)));
        System.out.println("================================");

        s = "catsandog";
        words = new String[]{"cats", "dog", "sand", "and", "cat"};
        System.out.println("S: "+s+ "  Dict:"+ Arrays.toString(words));
        System.out.println("Can Break? "+wb.wordBreak(s, Arrays.asList(words)));
        System.out.println("================================");
    }

    /**
     *
     * DP[i] denotes whether we can break s[0:i-1]
     * DP[i] = DP[j] if s[j:i-1] in dictionary
     *
     * How to efficiently decide if s[j:i-1] is in dictionary or not?
     * Using HashSet to store dict.
     *
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> dict = new HashSet<>();

        for(String word : wordDict){
            dict.add(word);
        }

        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for(int i = 0; i < len; ++i){
            if(dp[i]){
                int j = 1;
                while(i+j <= len){
                    if(dict.contains(s.substring(i, i+j))){
                        dp[i+j] = true;
                    }
                    ++j;
                }
            }
        }

        return dp[len];
    }
}
