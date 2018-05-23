import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class SearchinRotatedSortedArrayII {

    public static void main(String[] args){
        SearchinRotatedSortedArrayII srs = new SearchinRotatedSortedArrayII();

        int[] nums = new int[]{2,5,6,0,0,1,2};
        int target = 0;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        target = 3;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        target = 2;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        nums = new int[]{3,1,1,1,1};
        target = 3;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        nums = new int[]{1,0,1,1,1};
        target = 0;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        nums = new int[]{1,1,1,0,1};
        target = 0;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        target = 1;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));

        nums = new int[]{1,1,1,1,3};
        target = 3;
        System.out.println("Input: "+ Arrays.toString(nums)+" target:"+target+" Result:"+srs.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int rotate = findMinimalIdx(nums), len = nums.length;

        int l = 0, r = len-1;
        while(l < r){
            int rotatedl = (l+rotate)%len, rotatedr = (r+rotate)%len;
            int mid = (l+r) / 2, rotatedmid = (mid+rotate) % len;

            if(nums[rotatedmid] == target) return true;
            if(nums[rotatedmid] < target) l = mid+1;
            else r = mid;
        }

        if(nums[(l+rotate)%len] == target) return true;
        else return false;
    }


    /**
     * Function to find Idx of minimal should change.
     * Because, although we can find minimal number using solution in 154. FindMinimuminRotatedSortedArrayII,
     * we cannot ensure that it's the rotated idx since there might be duplicated minimals.
     *
     * Like [1,3,1,1] we might think 3 is the minimal idx, and [3,1,1,1] we might think 3 is the minimal idx as well.
     * But 3 is not rotated idx.
     *
     * So all we need to do is to modify logics in findMinimalIdx
     * Now we explore another property for rotated array.
     * How do we find rotated index?
     * The simplest way is to find an idx which leads nums[idx] < nums[idx-1], that idx is the rotated index.
     * One iteration, easy!
     * But it affects time complexity, it's O(n) now.
     *
     */

    private int findMinimalIdx(int[] nums){
        int idx = 1;
        while(idx < nums.length){
            if(nums[idx] < nums[idx-1]) return idx;
            ++idx;
        }

        return 0;
    }
}
