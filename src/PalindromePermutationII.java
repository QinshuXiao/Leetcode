class Solution {
    public List<String> generatePalindromes(String s) {
        int[] chars = new int[128];
        
        for(char ch : s.toCharArray())
            chars[ch]++;
        
        String odd = "";
        for(int i = 0; i < 128; ++i){
            if(chars[i] % 2 == 1){
                if(odd != "")
                    return new ArrayList<String>();
                
                odd = String.valueOf((char)i);
                chars[i]--;
            }
            chars[i] /= 2;
        }
        
        List<String> halfRes = generateHalfStrs(chars);
        List<String> res = new ArrayList<>();
        if(halfRes.size() == 0){
            res.add(odd);
        }
        else{
            for(String half : halfRes){
                res.add( half + odd + reverse(half));
            }
        }
        
        return res;
    }
    
    List<String> generateHalfStrs(int[] chars){
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < 128; ++i){
            if(chars[i] == 0)
                continue;
            chars[i]--;
            List<String> strs = generateHalfStrs(chars);
            if(strs.size() == 0){
                res.add(String.valueOf((char)i));
            }
            else{
                for(String str : generateHalfStrs(chars)){
                    res.add(String.valueOf((char)i)+str);
                }
            }
            chars[i]++;
        }
        
        return res;
    }
    
    String reverse(String s){
        String res = "";
        char[] sc = s.toCharArray();
        for(int j = sc.length-1; j >= 0; --j){
            res += sc[j];
        }
        
        return res;
    }
}