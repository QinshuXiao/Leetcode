class Solution {
    
    /*
     * DP
     * res[i][0] represents the minimal costs at day i ending with 1-day pass
     * res[i][1] represents the minimal costs at day i ending with 7-day pass
     * res[i][2] represents the minimal costs at day i ending with 30-day pass
     */
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0)
            return 0;
        if(days.length == 1)
            return costs[0];
        
        boolean[] visitDay = new boolean[366];
        Arrays.fill(visitDay, false);
        for(int day : days){
            visitDay[day] = true;
        }
        
        int[][] minCosts = new int[366][3];
        minCosts[0][0] = minCosts[0][1] = minCosts[0][2] = 0;
        
        for(int i = 1; i <= 365; ++i){
            // if we travel at day i, then update the DP matrix
            if(visitDay[i]){
                
                // end with 1-day pass
                int minCost = Math.min(minCosts[i-1][0], 
                            Math.min(minCosts[i-1][1], minCosts[i-1][2]));
                minCosts[i][0] = minCost + costs[0];
                
                // end with 7-day pass
                if(i >= 7){
                    minCost = Math.min(minCosts[i-7][0], 
                            Math.min(minCosts[i-7][1], minCosts[i-7][2]));
                    minCosts[i][1] = minCost + costs[1];
                }
                else
                    minCosts[i][1] = costs[1];
                
                //end with 30-day pass
                if(i >= 30){
                    minCost = Math.min(minCosts[i-30][0], 
                            Math.min(minCosts[i-30][1], minCosts[i-30][2]));
                    minCosts[i][2] = minCost + costs[2];
                }
                else
                    minCosts[i][2] = costs[2];
            }
            // if we don't travel at day i, then just easily use the result in day i-1.
            else{
                minCosts[i][0] = minCosts[i-1][0];
                minCosts[i][1] = minCosts[i-1][1];
                minCosts[i][2] = minCosts[i-1][2];
            }
        }
        
        return Math.min(minCosts[365][0], 
                Math.min(minCosts[365][1], minCosts[365][2]));
    }
}