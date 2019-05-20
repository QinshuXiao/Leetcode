class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length, cols = rows == 0 ? 0 : grid[0].length; 
        
        for(int x = 0; x < rows; ++x){
            for(int y = 0; y < cols; ++y){
                if(grid[x][y] == 1){
                    int area = computeArea(x, y, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int computeArea(int x, int y, int[][] grid){
        if(x < 0 || x >= grid.length ||
          y < 0 || y >= grid[x].length ||
          grid[x][y] == 0)
            return 0;
        
        grid[x][y] = 0;
        return computeArea(x+1, y, grid) +
            computeArea(x-1, y, grid) +
            computeArea(x, y+1, grid) +
            computeArea(x, y-1, grid) +
            1;
    }
    
}