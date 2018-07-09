import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/7/8.
 */
public class HouseRobber {

    public static void main(String[] args){
        HouseRobber robber = new HouseRobber();

        int[] nums = new int[]{1,2,3,1};
        System.out.println("nums: "+ Arrays.toString(nums) + " Result: "+robber.rob(nums));

        nums = new int[]{1,2,3,6};
        System.out.println("nums: "+ Arrays.toString(nums) + " Result: "+robber.rob(nums));

        nums = new int[]{1,5,3};
        System.out.println("nums: "+ Arrays.toString(nums) + " Result: "+robber.rob(nums));
    }

    /**
     * Easy DP:
     *
     * There are only two options for each room:
     * 1. either steal (dp[i-2]+nums[i])
     * 2. Or give up (dp[i-1])
     *
     * We choose one which produces larger amount of money.
     *
     */
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; ++i){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }
}
