
import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/25.
 */
public class FindPeakElement {

    public static void main(String[] args){
        FindPeakElement fpe = new FindPeakElement();

        int[] nums = {1,2,3,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+fpe.findPeakElement(nums));

        nums = new int[]{1,2,1,3,5,6,4};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+fpe.findPeakElement(nums));
    }

    /**
     *
     * It said we need to solve it in O(lgn)
     * Without doubt, we need to try Binary Search
     *
     */

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;

        while(l < r){
            int mid = l + (r-l)/2;

            if(nums[mid] > nums[mid+1] ) {
                if(mid == 0 || nums[mid] > nums[mid-1]) return mid;
                else r = mid;
            }
            else l = mid + 1;
        }

        return l;
    }
}
