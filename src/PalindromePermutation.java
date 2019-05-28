class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] chars = new int[128];
        Arrays.fill(chars, 0);
        
        for(char ch : s.toCharArray()){
            chars[ch]++;
        }
        
        int odds = 0;
        
        for(int i = 0; i < 128; ++i){
            if(chars[i] % 2 == 1)
                odds++;
            
            if(odds > 1)
                return false;
        }
        
        return true;
    }
}