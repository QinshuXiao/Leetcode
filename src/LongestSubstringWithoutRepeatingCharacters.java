/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters finder = new LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcba";
        System.out.println("Input: "+s+"  Result: "+finder.lengthOfLongestSubstring(s));

        s = "bbbb";
        System.out.println("Input: "+s+"  Result: "+finder.lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println("Input: "+s+"  Result: "+finder.lengthOfLongestSubstring(s));
    }

    /**
     *
     * Two pointer + Something we can record the character we've seen
     * In this problem, we can use boolean array, as we are required to make sure s[slow:fast] contains only distinct characters.
     *
     * When we move fast pointer forward, we update our boolean array, to see if we have met s[fast]
     * If we've met s[fast], which means exist[s[fast]] == true, we move forward slow pointer, meanwhile update boolean array, until exist[s[fast]] == false
     * Every time we finish moving forward fast pointer, we update our result.
     *
     */

    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();

        char[] sc = s.toCharArray();
        int len = sc.length, res = 0, slow = 0, fast = 0;
        boolean[] exist = new boolean[128];
        for(int i = 0; i < 128; ++i) exist[i] = false;

        while(fast < len){
            if(exist[sc[fast]]){
                while(exist[sc[fast]] && slow < fast){
                    exist[sc[slow]] = false;
                    ++slow;
                }
            }

            exist[sc[fast]] = true;
            ++fast;
            res = Math.max(res, fast - slow);
        }

        return res;
    }
}
