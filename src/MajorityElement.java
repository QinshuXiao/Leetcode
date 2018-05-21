import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class MajorityElement {

    public static void main(String[] args){
        MajorityElement me = new MajorityElement();

        int[] nums = {3,2,3};
        System.out.println("Input: "+ Arrays.toString(nums)+ " Output: "+me.majorityElement(nums));

        nums = new int[] {2,2,1,1,1,2,2};
        System.out.println("Input: "+ Arrays.toString(nums)+ " Output: "+me.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int candidate = nums[0], cnt = 1;

        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == candidate){
                ++cnt;
            } else {
                --cnt;
                if(cnt == 0){
                    candidate = nums[i];
                    cnt = 1;
                }
            }
        }

        return candidate;
    }
}
