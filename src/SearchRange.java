import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class SearchRange {

    public static void main(String[] args){
        SearchRange sr = new SearchRange();

        int[] nums = {5,5,7,8,8,10,10,10};
        int target = 5;
        System.out.println("Input: "+ Arrays.toString(nums)+" Result: "+Arrays.toString(sr.searchRange(nums, target)));

        target = 6;
        System.out.println("Input: "+ Arrays.toString(nums)+" Result: "+Arrays.toString(sr.searchRange(nums, target)));

        target = 7;
        System.out.println("Input: "+ Arrays.toString(nums)+" Result: "+Arrays.toString(sr.searchRange(nums, target)));

        target = 8;
        System.out.println("Input: "+ Arrays.toString(nums)+" Result: "+Arrays.toString(sr.searchRange(nums, target)));

        target = 10;
        System.out.println("Input: "+ Arrays.toString(nums)+" Result: "+Arrays.toString(sr.searchRange(nums, target)));
    }

    /**
     *
     * Binary Search way:
     * Firstly search for the left-most end
     * Then search for the right-most end
     *
     */

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target, 0, nums.length-1);
        if(left == -1) return new int[]{-1, -1};

        int right = searchRight(nums, target, left, nums.length-1);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target, int l, int r){
        if(l > r) return -1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] >= target) r = mid;
            else l = mid+1;
        }

        if(nums[l] == target) return l;
        else return -1;
    }

    private int searchRight(int[] nums, int target, int l, int r){
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= target) l = mid+1;
            else r = mid;
        }

        if(l == nums.length-1 && nums[l] == target) return l;
        else if(l > 0 && nums[l-1] == target) return l-1;
        else return -1;
    }
}
