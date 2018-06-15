import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/6/14.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("Nums: "+ Arrays.toString(nums)+ " Result: "+lis.lengthOfLIS(nums));

        nums = new int[]{10,9,2,5,3,7,101,18,105};
        System.out.println("Nums: "+ Arrays.toString(nums)+ " Result: "+lis.lengthOfLIS(nums));

        nums = new int[]{4,10,4,3,8,9};
        System.out.println("Nums: "+ Arrays.toString(nums)+ " Result: "+lis.lengthOfLIS(nums));
    }

    /**
     * The key is to build LIS array.
     * How?
     *
     * I firstly think of Stack, but I notice that it will possibly drop off previous numbers
     * Like for [2,5,3,7,101,18,4,105]
     * When we meet 101, the stack would be like:
     * [2,3,7,101]
     * Then when 18 comes, it becomes [2,3,7,18]. Then 4 comes, it becomes [2,3,4].
     * Then finally 105 comes, we get [2,3,4,105].
     * So it makes us consider 4 as the answer.
     * But obviously, it's wrong, the answer should be 6, [2,3,7,18,105] or [2,3,7,101,105]
     *
     * So, we can't drop off any previous elements.
     * Then ArrayList + Binary Search came into my mind.
     * When meet the new number, we find the lower bound for it, then insert it in the lowerBoundIdx we just found.
     * But it's to slow. Insertion in ArrayList costs O(n).
     *
     * Well, at this point, we need to think about replacing numbers in LIS, instead of inserting numbers.
     * Suppose LIS[j] is lowerBound of num, then it's safe if we set LIS[j] to num.
     * Since num < LIS[j], it has a larger possibility to build longer LIS. So the length of LIS wouldn't be truncated.
     * For example, [2,5,3,7]
     * When we meet 5, LIS becomes [2,5]
     * Then 3 comes, LIS becomes [2,3]. This replacement is safe, because it didn't truncate LIS and it even increase the chance to build a longer LIS
     * In other words, [2,3,7] and [2,5,7] are both valid LIS, it doesn't matter the second element is 5 or 3.
     * For the purpose of build LIS as longer as possible, a smaller number would be more welcome.
     *
     */

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;

        int[] LIS = new int[nums.length];
        int top = 0;

        for(int num : nums){
            if(top == 0 || num > LIS[top-1]) LIS[top++] = num;
            else{
                int lowerBoundIdx = lowerBound(LIS, num, 0, top-1);
                LIS[lowerBoundIdx] = num;
            }
        }

        return top;
    }

    private int lowerBound(int[] nums, int target, int l ,int r){
        if(nums[r] < target) return r+1;

        while(l < r){
            int mid = l + (r-l)/2;

            if(nums[mid] < target) l = mid+1;
            else r = mid;
        }

        return l;
    }
}
