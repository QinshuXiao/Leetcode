class Solution {

    public int numJewelsInStones(String J, String S) {
        /*
         * Using boolean array to represent if a char exists in J, 
         * as a character can be represented as an integer.
         */
        boolean[] JJ = new boolean[128];
        Arrays.fill(JJ, false);
        char[] JC = J.toCharArray();
        for(char ch : JC)
            JJ[(int)ch] = true;
        
        /*
         * Iterate through S and count how many character which has value 'true' in the boolean array we generated above.
         */
        int res = 0;
        char[] SC = S.toCharArray();
        for(char ch : SC){
            if(JJ[(int)ch])
                ++res;
        }
        
        return res;
    }
}