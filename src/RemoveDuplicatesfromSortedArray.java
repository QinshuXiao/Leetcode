import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class RemoveDuplicatesfromSortedArray {

    static public void main(String[] args){
        RemoveDuplicatesfromSortedArray runner = new RemoveDuplicatesfromSortedArray();

        int[] nums = {1,2,3};
        System.out.println("Input: "+ Arrays.toString(nums));
        int rest = runner.removeDuplicates(nums);
        int[] res = new int[rest];
        for(int i = 0; i < rest; ++i) res[i] = nums[i];
        System.out.println("Result: "+ Arrays.toString(res));
        System.out.println();


        nums = new int[]{1,1,2,3,3,3};
        System.out.println("Input: "+ Arrays.toString(nums));
        rest = runner.removeDuplicates(nums);
        res = new int[rest];
        for(int i = 0; i < rest; ++i) res[i] = nums[i];
        System.out.println("Result: "+ Arrays.toString(res));
        System.out.println();

        nums = new int[]{1,1,2,3};
        System.out.println("Input: "+ Arrays.toString(nums));
        rest = runner.removeDuplicates(nums);
        res = new int[rest];
        for(int i = 0; i < rest; ++i) res[i] = nums[i];
        System.out.println("Result: "+ Arrays.toString(res));
    }

    /**
     *
     * It's classical problem in arrays. And classical two pointer solution
     * The algorithm is not complex. Difficulties come from edge cases.
     *
     * Slow pointer records the end of the array without duplicates
     * Fast pointer finds out the next number we've met.
     *
     */

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int slow = 0, fast = 0, len = nums.length;

        while(fast < len){
            while(fast < len && nums[fast] == nums[slow]) ++fast;
            if(fast == len) break;

            swap(nums, ++slow, fast++);

        }

        return slow+1;
    }

    private void swap(int[] nums, int slow, int fast){
        if(slow == fast) return;
        int tmp = nums[fast];
        nums[fast] = nums[slow];
        nums[slow] = tmp;
    }
}
