import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/13.
 */
public class PalindromePartitioning {

    /**
     *
     * DP for checking and finding Palindrome string.
     * Backtracking for partitioning palindrome string.
     *
     */

    public List<List<String>> partition(String s) {
        char[] sc = s.toCharArray();
        boolean[][] isP = buildDP(sc);

        List<List<String>> res = new ArrayList<>();
        bt(s, 0, isP, new ArrayList<String>(), res);

        return res;
    }

    private boolean[][] buildDP(char[] sc){
        boolean[][] isP = new boolean[sc.length][sc.length];

        for(int j = 0; j < sc.length; ++j){
            for(int i = j; i >= 0; --i){
                if(i == j) isP[i][j] = true;
                else if(i + 1 == j) isP[i][j] = (sc[i] == sc[j]);
                else isP[i][j] = isP[i+1][j-1] && (sc[i] == sc[j]);
            }
        }

        return isP;
    }

    private void bt(String s, int i, boolean[][] isP, List<String> cur, List<List<String>> res){
        if(i == s.length()) {
            res.add(new ArrayList(cur));
            return;
        }

        for(int j = i; j < s.length(); ++j){
            if(isP[i][j]){
                cur.add(s.substring(i, j+1));
                bt(s, j+1, isP, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }
}
