class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        int[] ans = new int[N];
        List<Integer>[] richTree = new List[N];
        
        for(int[] pair : richer){
            if(richTree[pair[0]] == null){
                richTree[pair[0]] = new ArrayList<Integer>();
            }
            richTree[pair[0]].add(pair[1]);
        }
        
        for(int i = 0 ; i < N; ++i) ans[i] = i;
        
        for(int i = 0; i < N; ++i){
            if(quiet[ans[i]] < quiet[i])
                continue;
            
            populateQuietRichPerson(i, ans, richTree, quiet, i);
        }
        
        return ans;
    }
    
    private void populateQuietRichPerson(int person, int[] ans, List<Integer>[] richTree, int[] quiet, int quietest){
        if(richTree[person] == null)
            return;
        
        for(int poorPerson : richTree[person]){
            if(quiet[ans[poorPerson]] > quiet[quietest]){
                ans[poorPerson] = quietest;
                populateQuietRichPerson(poorPerson, ans, richTree, quiet, quietest);
            }
        }
    }
}