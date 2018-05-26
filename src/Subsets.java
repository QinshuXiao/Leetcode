import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class Subsets {


    public static void main(String[] args){
        Subsets ss = new Subsets();

        int[] nums = {1,2,3};
        System.out.println("Input: "+ Arrays.toString(nums)+" Result: "+ss.subsets(nums));
    }

    /**
     *
     * All right, how to retrieve all subsets?
     * Firstly, let us figure out the logic between subset.
     * Suppose you have an array [x1, x2, x3,..., xn]
     * The subset of this array is that you pick up some elements from array to build a new array, which is one subset.
     * If you want to retrieve all subsets, you need to repeatedly do this job until you cannot find a new subset.
     *
     * So how many subsets can an array with n elements have?
     * The answer is 2^n
     *
     * So first solution is easy:
     * based on binary representation of number from 0 to 2^n, we pick up elements from array, if i-th position is 1 in binary representation, we pick up element at index i.
     * It's simple. But it cannot deal with one thing: what if there are duplicates in the array?
     *
     * So we need another solution, more general and more stable
     *
     * Let's explore this problem deeply. Let's see, we need to pick up elements, and collect all possibility.
     * Wait! "Pick" elements from an array, and enumerate all possible combinations, that reminded me of backtracking!
     * Well! basically backtracking can satisfy all enumeration requirements.
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
     * Explanation:
     * Just like we assign seats for elements.
     * x1 takes seat1, and the rest seats are assigned to [x2 .... xn]
     * or x2 takes seat1, and the rest seats are assigned to [x3, ...., xn]
     *
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        bt(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void bt(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList<>(cur));
        for(int i = idx; i < nums.length; i++){
            cur.add(nums[i]);
            bt(nums, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
