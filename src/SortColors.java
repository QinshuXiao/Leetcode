import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class SortColors {

    public static void main(String[] args){
        SortColors sc = new SortColors();

        int[] nums = {2,0,2,1,0,1,2};
        System.out.print("Input: "+ Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.print("  Result: "+Arrays.toString(nums)+"\n");

        nums = new int[]{0,1,2};
        System.out.print("Input: "+ Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.print("  Result: "+Arrays.toString(nums)+"\n");

        nums = new int[]{2,0,0,1,2};
        System.out.print("Input: "+ Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.print("  Result: "+Arrays.toString(nums)+"\n");

        nums = new int[]{2,1,0};
        System.out.print("Input: "+ Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.print("  Result: "+Arrays.toString(nums)+"\n");

        nums = new int[]{0,2,1,2};
        System.out.print("Input: "+ Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.print("  Result: "+Arrays.toString(nums)+"\n");

        nums = new int[]{1,2,0};
        System.out.print("Input: "+ Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.print("  Result: "+Arrays.toString(nums)+"\n");
    }

    /**
     *  Two pointers way, one is head, one is tail.
     *  put all 0 to head, put all 2 to tail.
     *
     *  head = 0
     *  tail = nums.length-1
     *
     *  while i <= tail:
     *      if(nums[i] == 0){
     *          swap(i, head)
     *          head++
     *          if(i < head) i = head;
     *      }
     *      else if(nums[i] == 2){
     *          swap(i, tail)
     *          --tail
     *      }
     *      else ++i
     *
     */

    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length-1;

        while(head < tail && nums[head] == 0) ++head;
        while(head < tail && nums[tail] == 2) --tail;

        for(int i = head; i <= tail; ){
            if(nums[i] == 0){
                swap(nums, head, i);
                ++head;
                if(head > i) i = head;
            }
            else if(nums[i] == 2){
                swap(nums, i, tail);
                --tail;
            }
            else ++i;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
