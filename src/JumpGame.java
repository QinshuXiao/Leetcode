import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class JumpGame {

    public static void main(String[] args){
        JumpGame jg = new JumpGame();

        int[] nums = {2,3,1,1,4};
        System.out.println("Input: "+ Arrays.toString(nums)+" result: "+String.valueOf(jg.canJump(nums)));

        nums = new int[]{3,2,1,0,4};
        System.out.println("Input: "+ Arrays.toString(nums)+" result: "+String.valueOf(jg.canJump(nums)));
    }

    public boolean canJump(int[] nums) {
        int longest = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(i > longest) return false;
            longest = Math.max(longest, nums[i] + i);
            if(longest >= nums.length-1) return true;
        }

        return true;
    }
}
