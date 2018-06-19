import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/19.
 */
public class WordSearchII {

    private static class node{
        public node[] children = null;
        public boolean end;
        public node(){
            children = new node[26];
            end = false;
        }
    }

    /**
     * Trie Tree stores dictionary
     * DFS searches words in mtx
     *
     */

    public List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0) return new ArrayList<String>();

        /**
         * Build trie tree
         */
        node root = new node();
        for(String word : words){
            if(word.length() == 0) continue;

            char[] wc = word.toCharArray();
            node cur = root;
            for(char ch : wc){
                if(cur.children[ch-'a'] == null){
                    cur.children[ch-'a'] = new node();
                }
                cur = cur.children[ch-'a'];
            }
            cur.end = true;
        }

        List<String> res = new ArrayList<>();
        for(int x = 0; x < board.length; ++x){
            for(int y = 0; y < board[x].length; ++y){
                dfs(board, x, y, root, new StringBuilder(), res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int x, int y, node cur, StringBuilder sb, List<String> res){
        if(cur.end){
            res.add(sb.toString());
            // for avoiding duplicate strings.
            cur.end = false;
        }
        if(x < 0 || x >= board.length) return;
        if(y < 0 || y >= board[x].length) return;
        if(board[x][y] == 0) return;
        if(cur.children[board[x][y] - 'a'] == null) return;

        char original = board[x][y];
        sb.append(board[x][y]);
        board[x][y] = 0;
        dfs(board, x+1, y, cur.children[original - 'a'], sb, res);
        dfs(board, x-1, y, cur.children[original - 'a'], sb, res);
        dfs(board, x, y+1, cur.children[original - 'a'], sb, res);
        dfs(board, x, y-1, cur.children[original - 'a'], sb, res);
        board[x][y] = original;
        sb.deleteCharAt(sb.length()-1);
    }
}
