/**
 * Created by qinshuxiao on 2018/6/18.
 */
public class LongestIncreasingPathinaMatrix {

    /**
     *
     * Those kind of Matrix problem, asking longest or shortest path,
     * the classical solution would be DFS + Memoization
     *
     * The reason why we use memoization is to possibly reduce the duplicate computations
     * As for mtx[i][j], we suppose we have find longest path started from [i][j], you don't have to compute again
     *
     */

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;

        int[][] memo = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int x = 0; x < matrix.length; ++x){
            for(int y = 0; y < matrix[x].length; ++y){
                res = Math.max(res, dfs(x, y, matrix, Integer.MIN_VALUE, memo));
            }
        }

        return res;
    }

    private int dfs(int x, int y, int[][] matrix, int adj, int[][] memo){
        if(x < 0 || x >= matrix.length) return 0;
        if(y < 0 || y >= matrix[0].length) return 0;

        if(matrix[x][y] <= adj) return 0;
        if(memo[x][y] > 0) return memo[x][y];

        adj = matrix[x][y];
        int res = 0;
        res = Math.max(dfs(x+1, y, matrix, adj, memo), res);
        res = Math.max(dfs(x-1, y, matrix, adj, memo), res);
        res = Math.max(dfs(x, y+1, matrix, adj, memo), res);
        res = Math.max(dfs(x, y-1, matrix, adj, memo), res);
        memo[x][y] = res+1;

        return res+1;
    }
}
