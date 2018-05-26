import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class SubsetII {

    public static void main(String[] args){
        SubsetII ss = new SubsetII();

        int[] nums = {1,2,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+ ss.subsetsWithDup(nums));

        nums = new int[]{1,2,3,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+ ss.subsetsWithDup(nums));

        nums = new int[]{3,2,1,2,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+ ss.subsetsWithDup(nums));

        nums = new int[]{3,2,1,2,2,3,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+ ss.subsetsWithDup(nums));
    }
    /**
     *
     * So it's follow-up for 78. Subsets
     *
     * Ok, so more general way to extract all subsets from an array is that:
     * 1. Sort array
     * 2. backtracking:
     *      bt(start, int[] nums, curList, result):
     *          result.add(curList)
     *
     *          for i := start to nums.length:
     *              curList.add(nums[i])
     *              bt(start+1, nums, curList, result)
     *              curList.remove(curList.size()-1)
     *              skip all following elements which are equal to nums[i]
     *
     *
     * The reason why we sort the array is that we can easily skip duplicates in the sorted array.
     *
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        bt(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void bt(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(cur));

        for(int i=idx; i < nums.length; ++i){
            cur.add(nums[i]);
            bt(nums, i+1, cur, res);
            cur.remove(cur.size()-1);
            while(i < nums.length-1 && nums[i+1] == nums[i]) ++i;
        }

    }
}
