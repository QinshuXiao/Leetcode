import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/6.
 */
public class GenerateParentheses {

    public static void main(String[] args){
        GenerateParentheses generator = new GenerateParentheses();

        int n = 3;
        System.out.println("N:"+n+" Result: "+generator.generateParenthesis(n));

        n = 2;
        System.out.println("N:"+n+" Result: "+generator.generateParenthesis(n));

        n = 0;
        System.out.println("N:"+n+" Result: "+generator.generateParenthesis(n));

        n = 4;
        System.out.println("N:"+n+" Result: "+generator.generateParenthesis(n));
    }

    /**
     *
     * It's a classical Backtracking type of question.
     * In every position, we have several choices. We can go two ways in one position, put eight '(' or ')'
     *
     * Note that, we always consider putting '(' firstly.
     * Because the number of '(' should never be less than ')'. Otherwise, it becomes invalid parentheses.
     *
     */

    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<String>();

        List<String> res = new ArrayList<String>();
        bt(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void bt(int l, int r, int n, StringBuilder sb, List<String> res){
        if(l == n && r == n){
            res.add(sb.toString());
            return;
        }

        /**
         * Consider putting '(' firstly.
         * Don't forget delete '(' we added.
         */
        if(l < n){
            sb.append('(');
            bt(l+1, r, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

        /**
         * Then go to ')'
         * But be very careful that the number of ')' should never be larger than the number of '('
         */
        if(l > r){
            sb.append(')');
            bt(l, r+1, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
