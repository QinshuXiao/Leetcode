import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/6/5.
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        String[] strs = {"flower","flock","florida"};
        System.out.println("Strs: "+ Arrays.toString(strs)+"  Common Prefix: "+ lcp.longestCommonPrefix(strs));

        strs = new String[]{"acc","ac","a"};
        System.out.println("Strs: "+ Arrays.toString(strs)+"  Common Prefix: "+ lcp.longestCommonPrefix(strs));

        strs = new String[]{"acc","ac","a", ""};
        System.out.println("Strs: "+ Arrays.toString(strs)+"  Common Prefix: "+ lcp.longestCommonPrefix(strs));

        strs = new String[]{"acc","acc","acc"};
        System.out.println("Strs: "+ Arrays.toString(strs)+"  Common Prefix: "+ lcp.longestCommonPrefix(strs));
    }

    /**
     *
     * Straightforward way.
     * Use a pointer to show which index we're at right now.
     * Every time we move forward this pointer, we do an iteration on strs, to check if characters at that index are the same among all strings.
     * If it is, continue moving forward pointer. Otherwise terminate and return.
     *
     */

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int end = 0;

        while(end < strs[0].length()){
            char ch = strs[0].charAt(end);
            for(int i = 1; i < strs.length; ++i){
                if(end == strs[i].length()){
                    return strs[0].substring(0, end);
                }

                if(strs[i].charAt(end) != ch){
                    return strs[0].substring(0, end);
                }
            }

            ++end;
        }

        return strs[0];
    }
}
