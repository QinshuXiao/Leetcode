class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        
        int len = s1.length();
        int[] alphabets = new int[26];
        for(int i = 0; i < len; ++i){
            alphabets[s1.charAt(i)-'a']++;
            alphabets[s2.charAt(i)-'a']--;
        }
        
        for(int i = 0; i < 26; ++i)
            if(alphabets[i] != 0)
                return false;
        
        for(int i = 1; i < len; ++i){
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) &&
              isScramble(s1.substring(i),s2.substring(i)))
                return true;
            else if(isScramble(s1.substring(0,i),s2.substring(len-i)) &&
                   isScramble(s1.substring(i),s2.substring(0,len-i)))
                return true;
        }
        
        return false;
    }
}