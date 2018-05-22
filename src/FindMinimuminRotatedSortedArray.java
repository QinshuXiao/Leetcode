import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args){
        FindMinimuminRotatedSortedArray runner = new FindMinimuminRotatedSortedArray();

        int[] nums = {3,4,5,1,2};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+runner.findMin(nums));

        nums = new int[] {4,5,6,7,0,1,2};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+ runner.findMin(nums));
    }

    /**
     *
     * The simplest way is one iteration, Time is O(n).
     * But this should not be the answer.
     *
     * The algorithm in searching which can be better than O(n) is only binary search.
     *
     * Even the sorted array was rotated. Two portion of array are still sorted.
     * Suppose it is rotated at index i, then [0 ... i] is still sorted, [i+1 ... len-1] is still sorted too
     *
     * We can use Binary Search to find out minimal element.
     *
     * [nums[l] .... nums[mid] .... nums[r]]
     *
     * if nums[l] < nums[mid] < nums[r]:
     *     which means no rotated happened on [l ... r]
     *     e.g. [1,2,3,4,5]
     *     r = mid;
     * if nums[l] < nums[mid] && nums[mid] > nums[r]:
     *     which means [l ... mid] is sorted part without rotation
     *     but [mid+1....r] might have rotations, minimal number should fall in this portion
     *     e.g. [3,4,5,1,2]
     *     l = mid + 1;
     * if nums[l] > nums[mid] > nums[r]:
     *     which means it's a reversed order in [l....r], minimal number should fall in [mid+1 ... r]
     *     e.g. [5,4,3,2,1]
     *     l = mid + 1;
     * if nums[l] > nums[mid] && nums[mid] < nums[r]:
     *     which means [mid+1, ... r] doesn't contain rotation, minimal element should be in [l ... mid]
     *     e.g. [4,5,1,2,3]
     *     r = mid
     *
     */

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while(l < r){
            int mid = l + (r-l) / 2;
            if(nums[l] < nums[mid]){
                if(nums[mid] < nums[r]) r = mid;
                else l = mid + 1;
            } else {
                if(nums[mid] > nums[r]) l = mid+1;
                else r = mid;
            }
        }

        return nums[l];
    }
}
