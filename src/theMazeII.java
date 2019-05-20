class Solution {
    private class stop{
        int x, y;
        int dist;
        
        stop(int i, int j, int dist){
            this.x = i;
            this.y = j;
            this.dist = dist;
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = rows == 0 ? 0 : maze[0].length;
        
        int[][] visited = new int[rows][cols];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j)
                visited[i][j] = Integer.MAX_VALUE;
        }
        
        Queue<stop> q = new LinkedList<>();
        q.add(new stop(start[0], start[1], 0));
        visited[start[0]][start[1]] = 0;
        int res = -1;
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                stop cur = q.poll();
                
                List<stop> nextStops = findNextStops(cur, maze);
                for(stop st : nextStops){
                    if(st.x == destination[0] && st.y == destination[1]){
                        if(res == -1)
                            res = st.dist;
                        else
                            res = Math.min(res, st.dist);
                        
                        continue;
                    }
                    
                    if(st.dist < visited[st.x][st.y]){
                        q.add(st);
                        visited[st.x][st.y] = st.dist;
                    }
                }
                
                --n;
            }
        }
        
        return res;
    }
    
    private List<stop> findNextStops(stop cur, int[][] maze){
        List<stop> res = new ArrayList<>();
        
        int x = cur.x;
        int y = cur.y;
        
        // up
        while(x >= 0 && maze[x][y] == 0){
            --x;
        }
        ++x;
        if(x < cur.x)
            res.add(new stop(x, y, cur.dist + cur.x-x));
        
        x = cur.x;
        // down
        while(x < maze.length && maze[x][cur.y] == 0){
            ++x;
        }
        --x;
        if(x > cur.x)
            res.add(new stop(x, y, cur.dist + x-cur.x));
        
        x = cur.x;
        //left
        while(y >= 0 && maze[x][y] == 0){
            --y;
        }
        ++y;
        if(y < cur.y)
            res.add(new stop(x, y, cur.dist + cur.y-y));
        
        //right
        y = cur.y;
        while( y < maze[x].length && maze[x][y] == 0){
            ++y;
        }
        --y;
        if(y > cur.y)
            res.add(new stop(x, y, cur.dist + y-cur.y));
        
        return res;
    }
}