/**
 * Created by qinshuxiao on 2018/6/13.
 */
public class SurroundedRegions {

    /**
     *
     * DFS.
     * We search the boundaries of board,
     * If there are 'O' in boundary, we do DFS on that 'O', in order to mark out the 'O's which will save from killing.
     *
     * @param board
     */

    public void solve(char[][] board) {
        if(board.length == 0) return;

        for(int x = 0; x < board.length; ++x){
            if(board[x][0] == 'O') mark(board, x, 0);
            if(board[x][board[x].length-1] == 'O') mark(board, x, board[x].length-1);
        }

        for(int y = 0; y < board[0].length; ++y){
            if(board[0][y] == 'O') mark(board, 0, y);
            if(board[board.length-1][y] == 'O') mark(board, board.length-1, y);
        }

        for(int x = 0; x < board.length; ++x){
            for(int y = 0; y < board[x].length; ++y){
                if(board[x][y] == 'O') board[x][y] = 'X';
                else if(board[x][y] == 'M') board[x][y] = 'O';
            }
        }

    }

    private void mark(char[][] board, int x, int y){
        if(x < 0 || x >= board.length) return;
        if(y < 0 || y >= board[x].length) return;
        if(board[x][y] != 'O') return;

        board[x][y] = 'M';
        mark(board,x+1,y);
        mark(board,x,y+1);
        mark(board,x-1,y);
        mark(board,x,y-1);
    }
}
