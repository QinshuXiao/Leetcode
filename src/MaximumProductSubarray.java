import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();

        int[] nums = {2, 3, -2, 4};
        System.out.println("Input: " + Arrays.toString(nums) + " Output: " + mps.maxProduct(nums));

        nums = new int[]{-2, 0, -1};
        System.out.println("Input: " + Arrays.toString(nums) + " Output: " + mps.maxProduct(nums));

    }

    /**
     *
     * A simple DP solution
     *
     * max[i]: the maximum product until index i.
     * min[i]: the minimum product until index i.
     *
     * max[i] = max(nums[i], max[i-1] * nums[i]) if nums[i] > 0
     *        = max(nums[i], min[i-1] * nums[i]) if nums[i] < 0
     *
     * min[i] = min(nums[i], min[i-1] * nums[i]) if nums[i] > 0
     *        = min(nums[i], max[i-1] * nums[i]) if nums[i] < 0
     *
     */

    public int maxProduct(int[] nums) {
        int len = nums.length, res = nums[0];
        int[] min = new int[len];
        int[] max = new int[len];

        min[0] = max[0] = nums[0];
        for(int i = 1; i < len; ++i){
            if(nums[i] < 0){
                max[i] = Math.max(nums[i], min[i-1]*nums[i]);
                min[i] = Math.min(nums[i], max[i-1]*nums[i]);
            } else if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i-1]*nums[i]);
                min[i] = Math.min(nums[i],min[i-1]*nums[i]);
            }

            res = Math.max(res, max[i]);
        }

        return res;
    }
}
