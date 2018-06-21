import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/6/20.
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args){
        IncreasingTripletSubsequence finder = new IncreasingTripletSubsequence();

        int[] nums = new int[]{2,3,1,3,2,4,1,4,5};
        System.out.println("Input: "+ Arrays.toString(nums)+"  Result: "+finder.increasingTriplet(nums));

        nums = new int[]{3,4,2,1,3,2};
        System.out.println("Input: "+ Arrays.toString(nums)+"  Result: "+finder.increasingTriplet(nums));

        nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println("Input: "+ Arrays.toString(nums)+"  Result: "+finder.increasingTriplet(nums));
    }

    /**
     *
     * If one sequence contains Increasing Triple Subsequence,
     * it means this array contains at least one increasing subsequence with 3 numbers.
     *
     * So we can borrow the solution from **Longest Increasing Subsequence**
     * Then if we find one Increasing Subsequence which has 3 numbers, we return True, otherwise return false.
     *
     */

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int[] stack = new int[3];
        int top = 0;

        for(int num : nums){
            if(top == 0 || stack[top-1] < num) stack[top++] = num;
            else{
                int lowerBoundIdx = lowerBound(stack, num, 0, top-1);
                stack[lowerBoundIdx] = num;
            }
            if(top == 3) return true;
        }

        return top == 3;
    }

    private int lowerBound(int[] nums, int target, int l, int r){
        if(nums[r] < target) return r+1;

        while(l < r){
            int mid = l + (r-l)/2;

            if(nums[mid] < target) l = mid+1;
            else r = mid;
        }
        return l;
    }
}
