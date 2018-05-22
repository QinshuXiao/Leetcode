import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class FindMinimuminRotatedSortedArrayII {
    public static void main(String args[]){
        FindMinimuminRotatedSortedArrayII runner = new FindMinimuminRotatedSortedArrayII();

        int[] nums = new int[] {1,1,1,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " result: "+runner.findMin(nums));

        nums = new int[]{3,3,3,1,2};
        System.out.println("Input: "+ Arrays.toString(nums) + " result: "+runner.findMin(nums));

        nums = new int[]{1,3,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " result: "+runner.findMin(nums));

        nums = new int[]{3,1,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " result: "+runner.findMin(nums));

        nums = new int[]{1,0,1,1,1,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " result: "+runner.findMin(nums));

        nums = new int[]{1,1,1,1,0,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " result: "+runner.findMin(nums));
    }

    /**
     * Almost like the solution of 153. Find Minimum in Rotated Sorted Array
     * Allow duplicates affect the run-time complexity.
     *
     * If nums[l] is not equal to nums[r], we still can find out the relationship between nums[l], nums[mid] and nums[r]
     * if nums[l] == nums[mid] && nums[mid] < nums[r]:
     *      [1,1,1,3]
     *     which means [mid+1 ... r] is sorted without rotation, minimal should fall into [l ... mid]
     *     r = mid
     * if nums[l] == nums[mid] && nums[mid] > nums[r]:
     *      [3,3,3,1,2]
     *     which means minimal should fall into [mid+1 ... r]
     *     l = mid+1
     * if nums[l] < nums[mid] && nums[mid] == nums[r]:
     *      [1,3,3]
     *     obviously, minimal falls into [l, mid]
     *     r = mid
     * if nums[l] > nums[mid] && nums[mid] == nums[r]:
     *      [3,1,1]
     *      minimal falls into [mid+1 ... r]
     *      l = mid+1
     *
     * The only tricky part is nums[l] == nums[r]
     * like [1,0,1,1] and [1,1,0,1]
     * Actually you don't know which part you need to search next time
     *
     * But we can also easily to solve this problem. We just decrease r by 1.
     * It's safe to do that decrement, because nums[l] is still here.
     *
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;

        while(l < r){
            int mid = l + (r-l)/2;

            if(nums[l] == nums[r]) r--;
            else if(nums[l] <= nums[mid]){
                if(nums[mid] <= nums[r]) r = mid;
                else l = mid+1;
            } else{
                if(nums[mid] <= nums[r]) r = mid;
                else l = mid+1;
            }
        }

        return nums[l];
    }
}
