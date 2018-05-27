import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class SpiralMatrix {

    public static void main(String[] args){
        SpiralMatrix sm = new SpiralMatrix();

        int[][] mtx = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input: "+ Arrays.deepToString(mtx)+"  Result:"+sm.spiralOrder(mtx));

        mtx = new int[][]{{1,2},{4,5},{7,8}};
        System.out.println("Input: "+ Arrays.deepToString(mtx)+"  Result:"+sm.spiralOrder(mtx));

        mtx = new int[][]{{1,2,3},{4,5,6}};
        System.out.println("Input: "+ Arrays.deepToString(mtx)+"  Result:"+sm.spiralOrder(mtx));

        mtx = new int[][]{{1},{4},{7}};
        System.out.println("Input: "+ Arrays.deepToString(mtx)+"  Result:"+sm.spiralOrder(mtx));

        mtx = new int[][]{{1,2,3}};
        System.out.println("Input: "+ Arrays.deepToString(mtx)+"  Result:"+sm.spiralOrder(mtx));

        mtx = new int[][]{};
        System.out.println("Input: "+ Arrays.deepToString(mtx)+"  Result:"+sm.spiralOrder(mtx));

    }


    /**
     * Four pointers to denote boundaries
     *
     * Edge cases are what if m != n. We need to check boundary every time we do one iteration
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<Integer>();
        int up = 0, btm = matrix.length-1, l = 0, r = matrix[0].length-1;

        List<Integer> res = new ArrayList<Integer>();

        while(up <= btm && l <= r){
            for(int i = l; i <= r; ++i) res.add(matrix[up][i]);
            ++up;
            if(up > btm) break;

            for(int j = up; j <= btm; ++j) res.add(matrix[j][r]);
            --r;
            if(l > r) break;

            for(int i = r; i >= l; --i) res.add(matrix[btm][i]);
            --btm;
            if(up > btm) break;

            for(int j = btm; j >= up; --j) res.add(matrix[j][l]);
            ++l;
        }


        return res;
    }
}
