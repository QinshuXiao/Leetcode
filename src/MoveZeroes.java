import java.awt.*;
import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class MoveZeroes {

    public static void main(String[] args){
        MoveZeroes mz = new MoveZeroes();

        int[] nums = {0,1,0,3,7};
        System.out.print("Input: "+ Arrays.toString(nums));
        mz.moveZeroes(nums);
        System.out.print(" Result: "+Arrays.toString(nums)+"\n");
    }

    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0, zeroIdx = 0;
        while(nonZeroIdx < nums.length){
            // 1.find first zero
            while(zeroIdx < nums.length && nums[zeroIdx] != 0) ++zeroIdx;

            // 2. find first nonzero behind
            nonZeroIdx = zeroIdx + 1;
            while(nonZeroIdx < nums.length && nums[nonZeroIdx] == 0) ++nonZeroIdx;

            if(nonZeroIdx < nums.length){
                nums[zeroIdx] = nums[nonZeroIdx];
                nums[nonZeroIdx] = 0;
            }
        }
    }
}
