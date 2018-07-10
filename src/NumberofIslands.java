import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/7/9.
 */
public class NumberofIslands {

    public static void main(String[] args){
        NumberofIslands counter = new NumberofIslands();

        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Grid: "+ Arrays.deepToString(grid));
        System.out.println("Number of Islands: "+counter.numIslands(grid));
        System.out.println("==========================================");


        grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Grid: "+ Arrays.deepToString(grid));
        System.out.println("Number of Islands: "+counter.numIslands(grid));
        System.out.println("==========================================");

        grid = new char[][] {
                {'1'},
                {'1'},
                {'0'},
                {'1'}
        };
        System.out.println("Grid: "+ Arrays.deepToString(grid));
        System.out.println("Number of Islands: "+counter.numIslands(grid));
        System.out.println("==========================================");

        grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','1','0','0'}
        };
        System.out.println("Grid: "+ Arrays.deepToString(grid));
        System.out.println("Number of Islands: "+counter.numIslands(grid));
        System.out.println("==========================================");
    }

    /**
     *
     * There are several solutions:
     * 1st solution: DFS
     * We iterate through all space of grid map, when we meet a grid, say grid[i][j], which value is '1'.
     * Then we know we meet a new island, and we use DFS to "clear" this island from the map.
     * What I mean "clear", I mean switch this island to the sea, which is make '1' to '0'.
     *
     * The advantage is fast.
     * The disadvantage is that we have to modify the grid.
     *
     * If we're not allowed to modify the grid, we can turn to 2nd solution:
     * Get helps from Union Find.
     *
     */

    public int numIslands(char[][] grid) {
        int res = 0;

        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ++res;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if(grid[x][y] == '0') return;

        grid[x][y] = '0';
        dfs(grid, x+1, y);
        dfs(grid, x, y+1);
        dfs(grid, x-1, y);
        dfs(grid, x, y-1);
    }
}
