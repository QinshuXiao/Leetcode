/**
 * Created by qinshuxiao on 2018/7/6.
 */
public class ValidAnagram {

    public static void main(String[] args){
        ValidAnagram matcher = new ValidAnagram();

        String s = "anagram";
        String t = "namarga";
        System.out.println("S:"+s+"  T:"+t+"  Result:"+matcher.isAnagram(s,t));

        s = "rat";
        t = "car";
        System.out.println("S:"+s+"  T:"+t+"  Result:"+matcher.isAnagram(s,t));
    }

    /**
     * 1st solution:
     * Sort two Strings, and then compare them.
     */
     /*
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray(), tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        int idx = 0;
        while(idx < sc.length && sc[idx] == tc[idx]){
            ++idx;
        }

        return idx == sc.length;
    }*/

    /**
     *
     * 2nd solution:
     * Using Array to store appearances of each character.
     * Then check if two string have the same Array.
     *
     */

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] cnt = new int[26];

        for(int i = 0; i < s.length(); ++i){
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; ++i){
            if(cnt[i] != 0) return false;
        }

        return true;
    }
}
