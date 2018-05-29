import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/28.
 */
public class PlusOne {

    public static void main(String[] args){
        PlusOne po = new PlusOne();

        int[] digits = {9,9,9};
        System.out.println("Input: "+ Arrays.toString(digits)+"  Result: "+Arrays.toString(po.plusOne(digits)));

        digits = new int[]{9,9,8};
        System.out.println("Input: "+ Arrays.toString(digits)+"  Result: "+Arrays.toString(po.plusOne(digits)));

        digits = new int[]{8,9,9,9};
        System.out.println("Input: "+ Arrays.toString(digits)+"  Result: "+Arrays.toString(po.plusOne(digits)));
    }

    /**
     *
     * Easy question. Care about advanced digit
     * Some corner cases:
     * 1. [9,9,9] -> [1, 0, 0, 0]
     *      So when we initialize the result array, we set the length (len+1)
     * 2. [9,9,8] -> [9,9,8]
     *      Because we don't have advanced digit when we finish computation, we need to drop off first number of
     *      the result array
     * 3. [8,9,9,9] -> [9,0,0,0]
     *      Note that we need to reset advanced digit to 0 when we don't have advanced digit.
     *
     */

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len+1];
        int adv = 0, idx = len;

        res[idx] = 1 + digits[len-1];
        if(res[idx] >= 10){
            adv = 1;
            res[idx] -= 10;
        }
        --idx;

        while(idx > 0){
            res[idx] = adv + digits[idx-1];
            if(res[idx] >= 10){
                adv = 1;
                res[idx] -= 10;
            } else {
                adv = 0;
            }
            --idx;
        }

        if(adv > 0){
            res[idx] += adv;
            return res;
        } else {
            int[] rres = new int[len];
            int i = 1;
            while(i <= len){
                rres[i-1] = res[i];
                ++i;
            }
            return rres;
        }
    }
}
