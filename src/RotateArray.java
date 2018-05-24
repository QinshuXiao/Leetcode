import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/23.
 */
public class RotateArray {

    public static void main(String[] args){
        RotateArray ra = new RotateArray();

        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        System.out.print("Input:"+ Arrays.toString(nums)+" k:"+k);
        ra.rotate(nums, k);
        System.out.print(" Result:"+ Arrays.toString(nums)+"\n");

        nums = new int[]{1,2,3,4,5,6,7};
        k = 10;
        System.out.print("Input:"+ Arrays.toString(nums)+" k:"+k);
        ra.rotate(nums, k);
        System.out.print(" Result:"+ Arrays.toString(nums)+"\n");

    }

    /**
     *
     * It's a very interesting solution.
     * If you want to rotate an array to the right by k steps, just do three steps:
     * 1. Reverse [0 to n]
     * 2. reverse [0 to k-1]
     * 3. reverse [k to n]
     *
     * That's it!
     *
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }
}
