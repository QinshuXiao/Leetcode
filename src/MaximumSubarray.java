import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class MaximumSubarray {

    public static void main(String[] args){
        MaximumSubarray ms = new MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+ms.maxSubArray(nums));

        nums = new int[]{1,1,1,-2,3};
        System.out.println("Input: " +Arrays.toString(nums) + " Result: "+ms.maxSubArray(nums));

        nums = new int[]{1,1,1,-4,6};
        System.out.println("Input: " +Arrays.toString(nums) + " Result: "+ms.maxSubArray(nums));
    }

    /**
     *
     * Basically the idea is the same with MaximumProductSubarray
     *
     * You see? When we talk about maximum or minimal subarray problem, we should try DP !
     *
     * Classical DP solution;
     *
     * currentMax[i] denotes the maximum sum of subarray ending at index i.
     * currentMax[i] = max(nums[i], nums[i] + currentMax[i-1])
     *
     *
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currentMax = nums[0], res = nums[0];
        for(int i = 1; i < len; ++i){
            currentMax = Math.max(nums[i], nums[i]+currentMax);
            res = Math.max(res, currentMax);
        }

        return res;
    }
}
