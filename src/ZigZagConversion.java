class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        char[] sc = s.toCharArray();
        
        // level string, storing each level's result
        String[] zigZag = new String[numRows];
        Arrays.fill(zigZag, "");
        
        // generate res level by level.
        int level = 0;
        boolean goDown = false;
        for(char ch : sc){
            zigZag[level] += ch;
            if(goDown){
                ++level;
                if(level == numRows){
                    level -= 2;
                    goDown = !goDown;
                }
            }
            else{
                --level;
                if(level < 0){
                    level += 2;
                    goDown = !goDown;
                }
            }
        }
        
        String res = "";
        for(String str : zigZag){
            res += str;
        }
        
        return res;
    }
}