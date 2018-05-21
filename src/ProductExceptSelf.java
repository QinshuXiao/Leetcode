import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class ProductExceptSelf {

    public static void main(String[] args){
        ProductExceptSelf pes = new ProductExceptSelf();

        int[] nums = {1,2,3,4};
        System.out.println("Input: "+ Arrays.toString(nums) +" Result: "+Arrays.toString(pes.productExceptSelf(nums)));
    }

    /**
     *
     * A simple DP way
     * right[i]: store product of values between i+1 to len-1
     * right[len-1] = 1
     *
     * left[i]: store product of values among 0 to i-1
     * left[0] = 1
     *
     * output[i] = left[i] * right[i]
     *
     *
     * Without doubt, we can do some optimization, merge two arrays into one.
     *
     */

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        output[len-1] = 1;

        for(int i = len-1; i > 0; --i){
            output[i-1] = nums[i] * output[i];
        }

        int acc = 1;
        for(int i = 0 ;i < len; ++i){
            output[i] *= acc;
            acc *= nums[i];
        }

        return output;
    }
}
