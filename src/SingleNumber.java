/**
 * Created by qinshuxiao on 2018/7/11.
 */
public class SingleNumber {


    /**
     *
     * Some math logics.
     * XOR operator!
     *
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];

        for(int i = 1; i < nums.length; ++i){
            res ^= nums[i];
        }

        return res;
    }
}
