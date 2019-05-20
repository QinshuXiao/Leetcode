class Solution {
    
    class Island{
        List<int[]> grids;
        
        Island(int x, int y, int[][] A){
            grids = new ArrayList<int[]>();
            getIsland(x,y,A);
        }
        
        void getIsland(int i, int j, int[][] A){
            int rows = A.length;
            int cols = rows == 0 ? 0:A[0].length;
            
            if(i < 0 || i >= rows ||
              j < 0 || j >= cols || A[i][j] == 0)
                return;
            
            grids.add(new int[] {i,j});
            A[i][j] = 0;
            getIsland(i+1, j, A);
            getIsland(i-1, j, A);
            getIsland(i, j-1, A);
            getIsland(i, j+1, A);
        }
        
        public boolean contains(int[] grid){
            for(int[] g : grids){
                if(g[0] == grid[0] && g[1] == grid[1])
                    return true;
            }
            
            return false;
        }
    }
    
    public int shortestBridge(int[][] A) {
        Island island1 = null;
        Island island2 = null;
        
        int rows = A.length, cols = rows == 0 ? 0:A[0].length;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(A[i][j] == 1){
                    if(island1 == null)
                        island1 = new Island(i,j,A);
                    else
                        island2 = new Island(i,j,A);
                }
            }
        }
        
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int[] grid : island1.grids){
            A[grid[0]][grid[1]] = 1;
            q.add(grid);
        }
        
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                int[] grid = q.poll();
                for(int[] nextStep : findNextStep(grid[0],grid[1],A)){
                    if(island2.contains(nextStep))
                        return res;
                    else if(A[nextStep[0]][nextStep[1]] == 0){
                        q.add(nextStep);
                        A[nextStep[0]][nextStep[1]] = 1;
                    }
                    
                }
                
                --n;
            }
            ++res;
        }
        
        return res;
    }
    
    
    private List<int[]> findNextStep(int x, int y, int[][] A){
        
        List<int[]> res = new ArrayList<>();
        //left
        if(y > 0){
            res.add(new int[]{x,y-1});
        }
        
        //right
        if(y < A[x].length-1){
            res.add(new int[]{x,y+1});
        }
        
        //up
        if(x > 0){
            res.add(new int[]{x-1,y});
        }
        
        //down
        if(x < A.length-1){
            res.add(new int[]{x+1,y});
        }
        
        return res;
    }
    
}