/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {

    public static void main(String[] args){
        LongestSubstringwithAtMostKDistinctCharacters finder = new LongestSubstringwithAtMostKDistinctCharacters();

        String s = "eceba";
        int k = 2;
        System.out.println("String: "+s + " k: "+k+" Result: "+finder.lengthOfLongestSubstringKDistinct(s, k));

        k = 4;
        System.out.println("String: "+s + " k: "+k+" Result: "+finder.lengthOfLongestSubstringKDistinct(s, k));

        s = "abgsjcbbjjjshaxbshajakwdbsuas";
        System.out.println("String: "+s + " k: "+k+" Result: "+finder.lengthOfLongestSubstringKDistinct(s, k));
    }

    /**
     *
     * When we meet this kind of question, asking us to find a substring, immediate thinking is two pointers.
     * But how we can know how many different character appear in an substring?
     * Using hashmap!
     *
     * So the answer is Two pointer + HashMap
     *
     * Two pointers: fast and slow, delimiting the substring s[slow:fast]
     * HashMap records how many different characters we have seen in s[slow:fast], and records the number of appearances of each character as well.
     * When we move fast pointer forward, we update our HashMap, put new character in HashMap or increase one character's appearances
     * When we move slow pointer forward, we decrease one character's appearances or remove ont character out of HashMap.
     * Through properly moving fast pointer and slow pointer, we make sure there are at most K entries in HashMap.
     *
     * And each time we finish moving pointers, we update our results.
     *
     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k >= s.length()) return s.length();
        if(k == 0) return 0;

        char[] sc = s.toCharArray();
        int len = sc.length, fast = 0, slow = 0, res = 0;
        //Map<Character, Integer> map = new HashMap<>();
        int[] map = new int[128];
        int existNum = 0;

        while(fast < len){
            map[sc[fast]]++;
            if(map[sc[fast]] == 1) ++existNum;

            while(existNum > k && slow <= fast){
                --map[sc[slow]];
                if(map[sc[slow]] == 0) --existNum;
                ++slow;
            }
            ++fast;
            res = Math.max(res, fast-slow);
        }

        return res;
    }
}
