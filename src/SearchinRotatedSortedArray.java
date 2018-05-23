import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class SearchinRotatedSortedArray {

    public static void main(String[] args){
        SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Input: "+ Arrays.toString(nums) + " Target: "+target +" result: " + srsa.search(nums, target));

        target = 3;
        System.out.println("Input: "+ Arrays.toString(nums) + " Target: "+target +" result: " + srsa.search(nums, target));

        nums = new int[]{};
        System.out.println("Input: "+ Arrays.toString(nums) + " Target: "+target +" result: " + srsa.search(nums, target));
    }

    /**
     *
     * This problem is an interesting one.
     * Given that we are asked to think up with O(logn) solution, we have to think it in binary search way.
     *
     * One property for rotated array is that, for a real index i, after rotated, it would be (i+rotatedIdx)%len.
     *
     * So for our L and R, rotatedL = (L+rotatedIdx) % len, rotatedR = (R+rotatedR)%len.
     * And for mid = (L+R)/2, rotatedmid = (mid+rotatedIdx)%len
     *
     * So it becomes how we find rotatedIdx.
     * Recall the problem we solved yesterday: 153. FindMinimuminRotatedSortedArray
     *
     * We can directly borrow the idea from that solution, as the idx of minimal element is exactly the rotated idx.
     *
     * Clearly, the solution will be:
     *
     * 1. rotatedIdx = findMinimalIdx(nums)
     * 2. binary_search(nums, target, l, r):
     *        rotatedl = (l+rotatedIdx) % len
     *        rotatedr = (r+rotatedIdx) % len
     *        mid = (l+r)/2
     *        rotatedmid = (mid+rotatedIdx) % len
     *
     *        if(nums[rotatedmid] == target) return rotatedmid
     *        else if(nums[rotatedmid] < target) return binary_search(nums, target, mid+1, r)
     *        else return binary_search(nums, target, l, mid)
     *
     */

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int rotate = findMinimalIdx(nums), len = nums.length;

        int l = 0, r = len-1;
        //rotatedl = (l+rotate)%len, rotatedr = (r+rotate)%len
        // mid = (l+r)/2, roatatedmid = (mid+rotate) % len
        while(l < r){
            int rotatedl = (l+rotate)%len, rotatedr = (r+rotate)%len;
            int mid = (l+r) / 2, rotatedmid = (mid+rotate) % len;

            if(nums[rotatedmid] == target) return rotatedmid;
            if(nums[rotatedmid] < target) l = mid+1;
            else r = mid;
        }

        if(nums[(l+rotate)%len] == target) return (l+rotate)%len;
        else return -1;
    }

    /**
     * find index at which we rotate array,
     * which is find index of minimal element
     * o(n)
     */
    private int findMinimalIdx(int[] nums){
        int l = 0, r = nums.length-1;

        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[l] < nums[mid]){
                if(nums[mid]<nums[r]) return l;
                else l = mid+1;
            }
            else {
                if(nums[mid] > nums[r]) return r;
                else r = mid;
            }
        }

        return l;
    }
}
