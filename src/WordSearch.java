import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class WordSearch {

    public static void main(String[] args){
        WordSearch ws = new WordSearch();

        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Input: " + Arrays.deepToString(board) + " Word: "+word + " Result: "+ws.exist(board,word));

        word = "SEE";
        System.out.println("Input: " + Arrays.deepToString(board) + " Word: "+word + " Result: "+ws.exist(board,word));

        word = "ABCB";
        System.out.println("Input: " + Arrays.deepToString(board) + " Word: "+word + " Result: "+ws.exist(board,word));
    }

    /**
     * Classical DFS. When we meet a problem which asks us to search in matrix, we should consider DFS or BFS
     *
     * Using recursion to achieve DFS. Note that we have to mark position we've walked through.
     *
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = m==0?0:board[0].length;

        char[] wc = word.toCharArray();
        for(int i = 0; i < m; ++i){
            for(int j = 0;j<n;++j){
                if(dfs(board, i, j, 0, wc)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int i, char[] word){
        if(i == word.length) return true;
        if(x <0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0) return false;
        if(board[x][y] != word[i]) return false;

        char old = board[x][y];
        board[x][y] = 0;
        boolean res = dfs(board, x-1, y, i+1, word) || dfs(board, x+1, y, i+1, word)
                || dfs(board, x, y-1, i+1, word) || dfs(board, x, y+1, i+1, word);
        board[x][y] = old;
        return res;
    }
}
