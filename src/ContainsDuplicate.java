import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qinshuxiao on 2018/5/29.
 */
public class ContainsDuplicate {

    public static void main(String[] args){
        ContainsDuplicate cd = new ContainsDuplicate();

        int[] nums = {1,2,3,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " Contains Duplicate: "+cd.containsDuplicate2(nums));

        nums = new int[]{1,2,3,4};
        System.out.println("Input: "+ Arrays.toString(nums) + " Contains Duplicate: "+cd.containsDuplicate2(nums));

    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);

        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1; ++i){
            if(nums[i] == nums[i+1]) return true;
        }

        return false;
    }
}
