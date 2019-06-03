class Solution {
    private class tree{
        int x, y, h;
        tree(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        
        // using priorityqueue to sort the trees by their heights.
        PriorityQueue<tree> pq = new PriorityQueue<>((a,b) -> (a.h-b.h));
        int rows = forest.size();
        int cols = forest.get(0).size();
        
        int[][] grids = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; ++j){       
                grids[i][j] = forest.get(i).get(j);
                if(grids[i][j] > 1){
                    pq.add(new tree(i,j,grids[i][j]));
                }
            }
        }
        
        int res = 0;
        int[] curPos = new int[]{0,0};
        
        // cut the next tree one by one.
        // compute the distance between the current pos and the next tree's pos using BFS
        while(!pq.isEmpty()){
            tree nextTree = pq.poll();
            int shortestDist = dist(curPos, new int[]{nextTree.x, nextTree.y}, grids);
            if(shortestDist == -1)
                return -1;
            
            res += shortestDist;
            curPos[0] = nextTree.x;
            curPos[1] = nextTree.y;
        }
        
        return res;
    }
    
    // bfs to compute the shortest path between 2 nodes.
    private int dist(int[] src, int[] dst, int[][] forest){
        if(src[0] == dst[0] && src[1] == dst[1])
            return 0;
        
        int rows = forest.length;
        int cols = forest[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        
        q.add(src);
        visited[src[0]][src[1]] = true;
        while(!q.isEmpty()){
            int n = q.size();
            
            while(n > 0){
                int[] cur = q.poll();
                
                if(cur[0] == dst[0] && cur[1] == dst[1])
                    return res;
                
                int[] dir = new int[] {-1,0,1,0,-1};
                for(int i = 0; i < dir.length-1; ++i){
                    if( cur[0]+dir[i] < 0 || cur[0]+dir[i] >= rows ||
                       cur[1]+dir[i+1] < 0 || cur[1]+dir[i+1] >= cols ||
                       forest[cur[0]+dir[i]][cur[1]+dir[i+1]] == 0 ||
                       visited[cur[0]+dir[i]][cur[1]+dir[i+1]])
                        continue;
                    
                    visited[cur[0]+dir[i]][cur[1]+dir[i+1]] = true;
                    q.add(new int[] {cur[0]+dir[i], cur[1]+dir[i+1]});
                }
                
                --n;
            }
            ++res;
        }
        
        return -1;
    }
}