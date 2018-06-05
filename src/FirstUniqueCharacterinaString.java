/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class FirstUniqueCharacterinaString {

    public static void main(String[] args){
        FirstUniqueCharacterinaString finder = new FirstUniqueCharacterinaString();

        String s = "leetcode";
        System.out.println("Input: "+s+" Result: "+finder.firstUniqChar(s));

        s = "loveleetcode";
        System.out.println("Input: "+s+" Result: "+finder.firstUniqChar(s));

        s = "aabbccdd";
        System.out.println("Input: "+s+" Result: "+finder.firstUniqChar(s));
    }

    /**
     *
     * Easy problem! Two pass iteration
     * Using an array to store appearances of characters
     * Then do one more iteration to find first unique character
     *
     */

    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;

        int[] cnt = new int[26];
        char[] sc = s.toCharArray();

        for(char ch : sc) cnt[ch-'a']++;

        for(int i = 0; i < sc.length; ++i){
            if(cnt[sc[i]-'a'] == 1) return i;
        }

        return -1;
    }

}
