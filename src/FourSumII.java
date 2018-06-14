import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/6/14.
 */
public class FourSumII {
    public static void main(String[] args){
        FourSumII runner = new FourSumII();

        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println("A: "+ Arrays.toString(A));
        System.out.println("B: "+ Arrays.toString(B));
        System.out.println("C: "+ Arrays.toString(C));
        System.out.println("D: "+ Arrays.toString(D));
        System.out.println("Result: "+runner.fourSumCount(A,B,C,D));

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) return 0;

        /**
         * Firstly, travel through the whole A and B, and record A[i] + B[j] into HashMap.
         */
        Map<Integer, Integer> abSum = new HashMap<>();
        for(int i = 0; i < A.length; ++i){
            for(int j = 0; j < B.length; ++j){
                if(!abSum.containsKey(A[i]+B[j])){
                    abSum.put(A[i]+B[j], 1);
                } else {
                    abSum.put(A[i]+B[j], abSum.get(A[i]+B[j])+1);
                }
            }
        }

        /**
         * Secondly, travel through the whole A and B,
         * and check whether we can find (0-C[k]-D[l]) in the map.
         */
        int res = 0;
        for(int k = 0; k < C.length; ++k){
            for(int l = 0; l < D.length; ++l){
                if(abSum.containsKey(0-C[k]-D[l])){
                    res += abSum.get(0-C[k]-D[l]);
                }
            }
        }


        return res;
    }
}
