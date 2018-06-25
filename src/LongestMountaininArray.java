import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/6/25.
 */
public class LongestMountaininArray {

    public static void main(String[] args){
        LongestMountaininArray finder = new LongestMountaininArray();

        int[] A = new int[]{2,1,2,3,4,2};
        System.out.println("A: "+ Arrays.toString(A)+" Result: "+finder.longestMountain(A));

        A = new int[]{1,2,2,1};
        System.out.println("A: "+ Arrays.toString(A)+" Result: "+finder.longestMountain(A));

        A = new int[]{1,2,3,3,4,2,1};
        System.out.println("A: "+ Arrays.toString(A)+" Result: "+finder.longestMountain(A));

        A = new int[]{1,2,3,4,3,1};
        System.out.println("A: "+ Arrays.toString(A)+" Result: "+finder.longestMountain(A));

        A = new int[]{1,2,3,4,3,4,5,6,4,3,2,1};
        System.out.println("A: "+ Arrays.toString(A)+" Result: "+finder.longestMountain(A));
    }

    public int longestMountain(int[] A) {
        int res = 0, idx = 0;

        while(idx < A.length-1 && A[idx] >= A[idx+1]) ++idx;

        while(idx < A.length){
            int j = idx;
            boolean find = false;

            // find the peak
            while(j < A.length-1 && A[j] < A[j+1]) ++j;
            if(j == A.length-1) return res;

            // Be careful about platform.
            // If we meet platform, which means the element we're at isn't the actual peak.
            // A[i] can be the peak if and only if A[i-1] < A[i] > A[i+1]
            // So if we meet platform, we need to skip all of them.
            if(A[j] > A[j+1]) find = true;
            else{
                while(j < A.length-1 && A[j] == A[j+1]) ++j;
            }

            //find the lowest point
            while(j < A.length-1 && A[j] > A[j+1]) ++j;

            if(find) res = Math.max(res, j-idx+1);
            idx = j;
        }

        return res;
    }
}
