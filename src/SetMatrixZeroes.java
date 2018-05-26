import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class SetMatrixZeroes {

    public static void main(String[] args){
        SetMatrixZeroes runner = new SetMatrixZeroes();

        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println("Input: "+ Arrays.deepToString(matrix));
        runner.setZeroes(matrix);
        System.out.println("Result: "+ Arrays.deepToString(matrix));
        System.out.println();

        matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,0}};
        System.out.println("Input: "+ Arrays.deepToString(matrix));
        runner.setZeroes(matrix);
        System.out.println("Result: "+ Arrays.deepToString(matrix));
        System.out.println();

        matrix = new int[][]{{1,1,1}, {0,1,1}, {1,1,1}};
        System.out.println("Input: "+ Arrays.deepToString(matrix));
        runner.setZeroes(matrix);
        System.out.println("Result: "+ Arrays.deepToString(matrix));
        System.out.println();

        matrix = new int[][]{{1,0,1},{1,1,1},{1,1,1}};
        System.out.println("Input: "+ Arrays.deepToString(matrix));
        runner.setZeroes(matrix);
        System.out.println("Result: "+ Arrays.deepToString(matrix));
        System.out.println();

        matrix = new int[][]{{1,1,1,1},{1,0,1,1},{1,1,1,1}, {1,1,0,1}};
        System.out.println("Input: "+ Arrays.deepToString(matrix));
        runner.setZeroes(matrix);
        System.out.println("Result: "+ Arrays.deepToString(matrix));
        System.out.println();
    }

    /**
     * Well, the simplest way is to use o(2^n) space
     * the better way is to use two array, one denoting row and one denoting column, o(m+n)
     *
     * But... we are asked to use constant space.....
     * Alright, all we can only do is exploring matrix space we have now.
     *
     * Since all elements should turn to 0 if there is one 0 in the row or in the col, it doesn't matter if we set first element in this row or col to be 0
     * Therefore, we should use take use of first row and first col of input matrix.
     * If matrix[x][y] == 0, we should set matrix[x][0] and matrix[0][y] to 0.
     * And later, we iterate first row and first col to finish rest jobs, which is turning whole row or whole col to 0s.
     *
     * Be careful that first row and first col might not contain 0, which means they might not be changed.
     * But if we find matrix[x][y] to 0 where x > 1 and y > 1, which makes matrix[x][0] and matrix[0][y] to be 0, then we will turn first row and first col to 0s.
     * It's obviously not correct.
     *
     * So we should consider first row and first col as special spaces. Firstly we need to check if first row and first col should be set to 0s or not.
     * And then we do iteration from 1 to m for x and 1 to n for y, finding out 0 elements.
     * Then we turn i-th rows or i-th cols to 0 where i > 0.
     * Finally, based on the facts we found on 1st step, we do some necessary jobs, which might turn first row or first col to 0s.
     *
     *
     * For example:
     * 1 1 1 1
     * 1 0 1 1
     * 1 1 1 1
     * 1 1 0 1
     *
     * we get:
     * 1 0 0 1
     * 0 0 1 1
     * 1 1 1 1
     * 0 1 0 1
     *
     * It's just like we put 0 to up-most and left-most.
     * And later, we iterate first row and first col to finish rest jobs, which is turning whole row or whole col to 0s.
     * So we finally get:
     * 1 0 0 1
     * 0 0 0 0
     * 1 0 0 1
     * 0 0 0 0
     *
     */

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = m == 0?0: matrix[0].length;

        /**
         * Check if first column or first row should be set to 0s
         */
        boolean firstCol = false;
        for(int x = 0; x < m; ++x){
            if(matrix[x][0] == 0){
                firstCol = true;
                break;
            }
        }

        boolean firstRow = false;
        for(int y = 0; y < n; ++y){
            if(matrix[0][y] == 0){
                firstRow = true;
                break;
            }
        }

        /**
         * Find out 0 elements inside matrix
         * Put them to left-most and up-most grid.
         */
        for(int x = 1; x < m; ++x){
            for(int y = 1; y < n ;++y){
                if(matrix[x][y] == 0)
                    matrix[x][0] = matrix[0][y] = 0;
            }
        }


        /**
         * Turn i-th row and i-th col to 0s where i > 0
         */
        for(int x = 1; x < m; ++x){
            if(matrix[x][0] == 0){
                for(int y = 0; y < n; ++y) matrix[x][y] = 0;
            }
        }

        for(int y = 1; y < n; ++y){
            if(matrix[0][y] == 0){
                for(int x = 0; x < m; ++x) matrix[x][y] = 0;
            }
        }

        /**
         * Possibly turn 1st row and 1st col to 0s
         */
        if(firstCol){
            for(int x = 0; x < m; ++x) matrix[x][0] = 0;
        }

        if(firstRow){
            for(int y = 0; y < n; ++y) matrix[0][y] = 0;
        }
    }
}
