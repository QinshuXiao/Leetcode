import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/5/28.
 */
public class ThreeSum {

    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: "+Arrays.toString(nums)+" Result: "+ts.threeSum(nums));
    }

    /**
     *
     * Nothing fancy, classical sorting plus two pointers
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; ){
            int f = i+1, b = nums.length-1;

            while(f<b){
                if(nums[i]+nums[f]+nums[b] < 0){
                    ++f;
                    while(f < b && nums[f] == nums[f-1]) ++f;
                } else if(nums[i]+nums[f]+nums[b] > 0){
                    --b;
                    while(f<b && nums[b] == nums[b+1]) --b;
                } else {
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[f], nums[b]}));
                    ++f;
                    while(f < b && nums[f] == nums[f-1]) ++f;
                }
            }

            ++i;
            while(i < nums.length-2 && nums[i]==nums[i-1]) ++i;
        }

        return res;
    }
}
