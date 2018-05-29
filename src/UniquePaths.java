/**
 * Created by qinshuxiao on 2018/5/28.
 */
public class UniquePaths {

    public static void main(String[] args){
        UniquePaths up = new UniquePaths();

        int m = 3, n = 2;
        System.out.println("m="+m+" n="+n+" Result: "+up.uniquePaths(m, n));

        m = 8;
        n = 7;
        System.out.println("m="+m+" n="+n+" Result: "+up.uniquePaths(m, n));

        m = 1;
        n = 1;
        System.out.println("m="+m+" n="+n+" Result: "+up.uniquePaths(m, n));
    }

    /**
     *
     * Classical DP solution
     *
     */

    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        for(int i = 0; i < n; ++i) res[i] = 1;

        for(int r = 1; r < m; ++r){
            res[0] = 1;
            for(int i = 1; i < n; ++i){
                res[i] = res[i-1]+res[i];
            }
        }

        return res[n-1];
    }
}
