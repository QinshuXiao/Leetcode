class Solution {
    public String strWithout3a3b(int A, int B) {
        char[] res = new char[A+B];
        
        /*
         * Greedy algorithm
         * always put the character which has left more into the result firstly.
         * If we've already put 2 consective identical characters, then put the other one instead.
         */
        int i = 0;
        while(i < res.length){
            if(A > B){
                if(i >= 2 && res[i-2] == 'a' && res[i-1] == 'a'){
                    res[i] = 'b';
                    --B;
                }
                else{
                    res[i] = 'a';
                    --A;
                }
            }
            else{
                if(i >= 2 && res[i-2] == 'b' && res[i-1] == 'b'){
                    res[i] = 'a';
                    --A;
                }
                else{
                    res[i] = 'b';
                    --B;
                }
            }
            
            ++i;
        }
        
        return new String(res);
    }
}