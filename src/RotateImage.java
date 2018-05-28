import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/27.
 */
public class RotateImage {

    public static void main(String[] args){
        RotateImage ri = new RotateImage();

        int[][] mtx = {{1}};
        System.out.print("Input:" + Arrays.deepToString(mtx));
        ri.rotate(mtx);
        System.out.print(" Result: "+Arrays.deepToString(mtx)+"\n");

        mtx = new int[][] {{1,2},{3,4}};
        System.out.print("Input:" + Arrays.deepToString(mtx));
        ri.rotate(mtx);
        System.out.print(" Result: "+Arrays.deepToString(mtx)+"\n");

        mtx = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print("Input:" + Arrays.deepToString(mtx));
        ri.rotate(mtx);
        System.out.print(" Result: "+Arrays.deepToString(mtx)+"\n");

        mtx = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.print("Input:" + Arrays.deepToString(mtx));
        ri.rotate(mtx);
        System.out.print(" Result: "+Arrays.deepToString(mtx)+"\n");

    }

    /**
     *
     * To be honest, It's not a hard problem
     * You have to figure out you need to exchange which grid's data to which others
     *
     *     [r][c+i]
     *     ------>
     *    ^       |
     *    |       |
     *    |       |
     *    |       |
     *    |       V
     *    <-------
     *
     *    up side is [r][c+i]
     *    left side is [m-1-r-i][c]
     *    right side is [r+i][n-1-c]
     *    bottom side is [m-1-r][n-1-c-i]
     *
     */

    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;

        int m = matrix.length;
        int r = 0, c = 0;
        while(r < m/2){
            for(int i = 0; i < m-2*r-1; ++i){
                int tmp = matrix[r][c+i];
                matrix[r][c+i] = matrix[m-r-1-i][c];
                matrix[m-r-1-i][c] = matrix[m-r-1][m-c-1-i];
                matrix[m-r-1][m-c-1-i] = matrix[r+i][m-c-1];
                matrix[r+i][m-c-1] = tmp;

            }
            ++r;
            ++c;
        }
    }
}
