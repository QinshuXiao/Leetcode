class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        // stateMap store <state: day> pair
        // Using HashMap allows us to find cycle quickly
        Map<Integer, Integer> stateMap = new HashMap<Integer, Integer>();
        List<Integer> states = new ArrayList<>(); 
        
        int day = 1;
        int state = 0;
        
        // initialize the state at day 0
        for(int i = 0; i < 8; ++i)
            if(cells[i] == 1)
                state ^= (1 << i);
        
        int finalN = 0;
        while(day <= N){
            state = nextState(state);
            if(!stateMap.containsKey(state)){
                stateMap.put(state, day);
                states.add(state);
            }
            else{
                // Find duplicate elements, which means we find the cycle
                // Then the length of the cycle is day - day - stateMap.get(state)
                // The finalN is (N - stateMap.get(state)) % (day - stateMap.get(state))
                N -= stateMap.get(state);
                finalN = N % (day - stateMap.get(state));
                break;
            }
            ++day;
        }
        
        
        // find out the final state
        int finalState = states.get(finalN+stateMap.get(state)-1);
        
        // generate the final result array
        int[] res = new int[8];
        for(int i = 0; i < 8; ++i){
            if( ((finalState >> i) & 1) > 0 )
                res[i] = 1;
        }
        
        return res;
    }
    
    int nextState(int state){
        int res = 0;
        
        // only when two adjacent neighbors have the same value, a cell will become occupied.
        for(int i = 1; i <= 6; ++i){
            if (  ((state >> (i+1)) & 1)  == ((state >> (i-1)) & 1) )
                res ^= 1 << i;
        }
        
        return res;
    }
}