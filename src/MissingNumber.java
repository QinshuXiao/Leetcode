import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/23.
 */
public class MissingNumber {

    public static void main(String[] args){
        MissingNumber mn = new MissingNumber();

        int[] nums = {3,0,1};
        System.out.println("Input:"+ Arrays.toString(nums)+ " Result:"+mn.missingNumber(nums));

        nums = new int[]{1,2,3};
        System.out.println("Input:"+ Arrays.toString(nums)+ " Result:"+mn.missingNumber(nums));

        nums = new int[]{0,1,2};
        System.out.println("Input:"+ Arrays.toString(nums)+ " Result:"+mn.missingNumber(nums));

    }

    /**
     *
     * This kind of question: give you an array, and all elements are restricted in [0, n]. You should think about taking use of index space
     *
     * Using index space, when we meet the new number at index i, swap nums[i] and nums[nums[i]]
     * Then we do one more iteration to check at which index, the number is unmatched with index.
     *
     */
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; ){
            if(nums[i] == i || nums[i] == nums.length)  ++i;
            else{
                // swap(nums[i], nums[nums[i]])
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        int res = 0;
        for(; res < nums.length; ++res){
            if(nums[res] != res) return res;
        }

        return res;
    }
}
