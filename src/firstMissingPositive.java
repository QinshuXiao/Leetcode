import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class firstMissingPositive {

    public static void main(String[] args){
        firstMissingPositive fmp = new firstMissingPositive();

        int[] nums = {1,2,4,5};
        System.out.println("input:"+ Arrays.toString(nums) + " result = "+fmp.FirstMissingPositive(nums));

        nums = new int[]{1,3,2,5};
        System.out.println("input:"+ Arrays.toString(nums) + " result = "+fmp.FirstMissingPositive(nums));

        nums = new int[]{0,-1,2};
        System.out.println("input:"+ Arrays.toString(nums) + " result = "+fmp.FirstMissingPositive(nums));

        nums = new int[]{5,4,3,2,1};
        System.out.println("input:"+ Arrays.toString(nums) + " result = "+fmp.FirstMissingPositive(nums));
    }

    public firstMissingPositive(){

    }

    /**
     *
     * As the index space is from 0 to len-1, the result must fall in [1, len]
     * So we can take full use of index space of input array
     * Suppose we are currently at index i, we need to put element nums[i] into nums[nums[i]-1] if nums[i] is between(1, len)
     * This is first iteration.
     * Then we do another iteration, to check if i+1 == nums[i].
     * The first unmatched pair we meet is the result we want.
     *
     * i := 0
     * while i < len
     *     if nums[i] between 1 to len:
     *         swap nums[i] and nums[nums[i]-1]
     *     else:
     *         ++i
     *
     * for i := 0 to len-1
     *     if i+1 != nums[i]:
     *         return i+1
     *
     * return len(nums)+1
     */

    public int FirstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; ){
            if( nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1] ) {
                //swap nums[i] and nums[nums[i]-1]
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = tmp;

            } else {
                ++i;
            }
        }

        for(int i = 0; i < nums.length; ++i){
            if(i+1 != nums[i]) return i+1;
        }

        return nums.length+1;
    }
}
