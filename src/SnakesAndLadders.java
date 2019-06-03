class Solution {
    
    // classic BFS solution
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; ++i){
            Arrays.fill(visited[i], false);
        }
        int dest = N*N;
        
        Queue<int[]> q = new LinkedList<>();
        int[] startPos = posConvert(1, N);
        q.add(startPos);
        visited[startPos[0]][startPos[1]] = true;
        int res = 0;
        
        // BFS
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                startPos = q.poll();
                
                // if start point equals to N*N, then return;
                int x = gridToPos(startPos, N);
                if(x == dest)
                    return res;
                
                // bfs from x+1 to x+6
                for(int i = 1; i <= 6; ++i){
                    if(x + i > dest)
                        continue;
                    
                    int[] grid = posConvert(x+i, N);
                    
                    // if we have ladder and snake in that grid,
                    // just jump.
                    if(board[grid[0]][grid[1]] != -1){
                        grid = posConvert(board[grid[0]][grid[1]], N);
                    }
                    
                    // if we haven't visited that grid, then add it into queue
                    if(!visited[grid[0]][grid[1]]){
                        visited[grid[0]][grid[1]] = true;
                        q.add(grid);
                    }
                }
                --n;
            }
            ++res;
        }
        
        return -1;
    }
    
    // convert a pos ( int) to a grid in the board (int[])
    private int[] posConvert(int pos, int N){
        int row = N-1 - ( (pos-1) / N);
        int col = ( (pos-1) / N) % 2 == 0 ? 
            ( (pos-1) % N)  : (N-1) - ( (pos-1) % N);
        
        return new int[]{row, col};
    }
    
    // convert a grid in the board(int[]) to a pos value (int)
    private int gridToPos(int[] grid, int N){
        int row = grid[0];
        int col = grid[1];
        
        int res = (N-1-row) * N + 1;
        if( (N-1-row) % 2 == 0){
            res += col;
        }
        else{
            res += (N-1)-col;
        }
        
        return res;
    }
    
}