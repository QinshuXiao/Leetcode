/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args){
        MinimumWindowSubstring finder = new MinimumWindowSubstring();

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("s: "+s+" t: "+t+"  Result: "+finder.minWindow(s,t));

        t = "AABC";
        System.out.println("s: "+s+" t: "+t+"  Result: "+finder.minWindow(s,t));

        t = "F";
        System.out.println("s: "+s+" t: "+t+"  Result: "+finder.minWindow(s,t));
    }

    /**
     *
     * It's really similar to 340. Longest Substring with At Most K Distinct Characters
     * The method we use to solve this problem is almost the same with that one.
     *
     * Two pointers + HashMap
     * Two pointers: fast and slow, delimiting the substring s[slow:fast]
     * HashMap records how many different characters we have seen in s[slow:fast], and records the number of appearances of each character as well.
     *
     * When we move forward fast pointer, we increase the number of appearance of character we've met.
     * If we meet all characters required by string t, we update our result.
     * Then we try to move forward slow pointer, decreasing the number of appearance of character
     *
     *
     */

    public String minWindow(String s, String t) {
        if(t.length() == 0 || s.length() < t.length()) return "";
        if(s == t) return s;

        char[] tc = t.toCharArray(), sc = s.toCharArray();
        int tl = tc.length, sl = sc.length, windowStart = -1, minLen = sc.length;
        int slow = 0, fast = 0, rest = tl;

        int[] map = new int[128];

        for(char ch : tc){
            ++map[ch];
        }

        int[] cnt = new int[128];
        while(fast < sl){
            if(map[sc[fast]] > 0){
                cnt[sc[fast]]++;
                if(map[sc[fast]] >= cnt[sc[fast]]) --rest;
            }

            ++fast;
            while(rest == 0 && slow < fast){
                if(fast-slow <= minLen){
                    minLen = fast-slow;
                    windowStart = slow;
                }

                if(map[sc[slow]] > 0){
                    --cnt[sc[slow]];
                    if(map[sc[slow]] > cnt[sc[slow]]) ++rest;
                }
                ++slow;
            }
        }

        if(windowStart == -1) return "";
        return s.substring(windowStart, windowStart+minLen);
    }
}
