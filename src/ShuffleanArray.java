import java.util.Random;

/**
 * Created by qinshuxiao on 2018/7/1.
 */
public class ShuffleanArray {

    private int[] original = null;
    private int[] cur = null;

    /**
     * How to shuffle an array?
     * for each index i from array.length-1 to 0, you can find an random number j ranged from [0, i],
     * then swap array[i] and array[j]
     *
     * @param nums
     */

    public ShuffleanArray(int[] nums) {
        original = new int[nums.length];
        cur = new int[nums.length];

        for(int i = 0; i < nums.length; ++i) {
            original[i] = cur[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i = cur.length-1; i >= 0; --i){
            int j = rand.nextInt(i+1);
            swap(cur, i, j);
        }

        return cur;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
