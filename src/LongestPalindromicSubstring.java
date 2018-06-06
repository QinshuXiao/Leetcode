/**
 * Created by qinshuxiao on 2018/6/6.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        LongestPalindromicSubstring finder = new LongestPalindromicSubstring();

        String s = "ababa";
        System.out.println("S: "+s+"  Longest Palindrome: "+finder.longestPalindrome(s));

        s = "ababc";
        System.out.println("S: "+s+"  Longest Palindrome: "+finder.longestPalindrome(s));

        s = "abcccbd";
        System.out.println("S: "+s+"  Longest Palindrome: "+finder.longestPalindrome(s));

        s = "cccccbb";
        System.out.println("S: "+s+"  Longest Palindrome: "+finder.longestPalindrome(s));

        s = "abccc";
        System.out.println("S: "+s+"  Longest Palindrome: "+finder.longestPalindrome(s));
    }

    /**
     *
     * Well, It talks about Palindrome. So we think about two pointers naturally.
     * But when we check whether a string is palindrome or not, the way we operate two pointer is moving them towards each other.
     * Like for "abcba", usually we do:
     *  a  b  c  b  a
     *  ^           ^
     *  h-->     <--t
     *
     * Obviously, there are another way. We can also let them walk in opposite directions from the middle of string.
     * For example, for the string "abcba", we can do this:
     *  a   b   c   b   a
     *      ^   ^   ^
     *   <--b   i   f-->
     *
     * But there is one case we need to care about:
     * "abccccccba"
     *
     * we can see there are continuous 'c's in the string, actually we can skip all those 'c' when we locate our forward pointer
     *
     * a  b  c  c  c  c  b  a
     *    ^  ^           ^
     *    b  i           f
     * we can skip all identical 'c's and make forward pointer point to 'b'. Because "cccc" should be palindrome, we don't need to check them.
     *
     *
     */

    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int startIdx = 0, maxLen = 0, idx = 0;
        char[] sc = s.toCharArray();

        while(idx < sc.length - maxLen / 2){
            /**
             * Forward pointer
             * Skip all identical characters.
             */
            int forward = idx+1;
            while(forward < sc.length && sc[forward] == sc[idx]) ++forward;
            /**
             * Backward pointer
             * try to find longest palindrome via move forward or backward two pointers
             */
            int backward = idx-1;
            while(backward >= 0 && forward < sc.length && sc[backward] == sc[forward]){
                ++forward;
                --backward;
            }

            ++backward;
            if(forward-backward > maxLen){
                maxLen = forward-backward;
                startIdx = backward;
            }

            /**
             * Move forward idx.
             * Skip all identical characters
             */
            ++idx;
            while(idx < sc.length - maxLen / 2 && sc[idx] == sc[idx-1]) ++idx;
        }

        return s.substring(startIdx, startIdx + maxLen);
    }
}
