class Solution {
    public int countArrangement(int N) {
        boolean[] used = new boolean[N+1];
        Arrays.fill(used, false);
        int[] res = new int[1];
        res[0] = 0;

        // classic backtracking solution
        count(1, N, used, res);
        return res[0];
    }
    
    // classic backtracking solution
    private void count(int cur, int N, boolean[] used, int[] res){
        if(cur > N){
            res[0]++;
            return;
        }
        
        for(int i = 1; i <= N; ++i){
            if(used[i] || (cur % i != 0 && i % cur != 0))
                continue;
            
            used[i] = true;
            count(cur+1, N, used, res);
            used[i] = false;
        }
    }
}