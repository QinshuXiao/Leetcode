import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/7/12.
 */
public class SingleNumberII {

    public static void main(String[] args){
        SingleNumberII sn = new SingleNumberII();

        int[] nums = new int[]{1,1,1,2,2,3,2};
        System.out.println("nums: "+ Arrays.toString(nums) + " Single number: "+sn.singleNumber(nums));

        nums = new int[]{4,1,4,4};
        System.out.println("nums: "+ Arrays.toString(nums) + " Single number: "+sn.singleNumber(nums));

        nums = new int[]{0,0,1,0};
        System.out.println("nums: "+ Arrays.toString(nums) + " Single number: "+sn.singleNumber(nums));

        nums = new int[]{3,5,2,1,2,2,5,3,5,3};
        System.out.println("nums: "+ Arrays.toString(nums) + " Single number: "+sn.singleNumber(nums));
    }

    /**
     *
     * Borrow Bitwise ideas.
     * As only one element appears once, all the other appear three times,
     * If a bitwise has seen either 4 times of '1' or only once of '1', that bitwise belongs to single number.
     *
     * So we can depict a state machine.
     *
     * "One" denotes the bit sequence which meets once '1'
     * "Two" denotes the bit sequence which meets twice of '1'
     *
     * The state machine should be like:
     *       1    1
     * one 0 -> 1 ->  0
     *     ^          |
     *     |_____1____|
     *
     *       1    1
     * two 0 -> 0 -> 1
     *     ^         |
     *     |____1____|
     *
     * So we can get:
     * one = (one ^ num) & (~two)
     * two = (two ^ num) & (~one)
     */

    public int singleNumber(int[] nums) {
        int one = 0, two = 0;

        for(int num : nums){
            one = (one^num) & (~two);
            two = (two^num) & (~one);
        }

        return one;
    }
}
