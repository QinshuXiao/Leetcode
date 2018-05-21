import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class threeSumClosest {

    /**
     *
     * Nothing fancy, It's just like standard 3sum problem.
     * 1. sort + two pointers + iterations(for determine first element)
     * 2. record the gap between target and sum.  abs(target, sum)
     *
     */

    public static void main(String[] args){
        threeSumClosest runner = new threeSumClosest();

        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println("result = "+runner.getThreeSumClosest(nums, target));
    }

    public threeSumClosest() {

    }

    public int getThreeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 1 << 31 - 1;

        for(int i = 0; i < nums.length - 2; ++i){
            int m = i+1, n = nums.length-1;
            while(m < n){
                if(Math.abs(res - target) > Math.abs(nums[i] + nums[m] + nums[n] - target))
                    res = nums[i] + nums[m] + nums[n];

                if(nums[i] + nums[m] + nums[n] < target){
                    ++m;
                } else if (nums[i] + nums[m] + nums[n] > target) {
                    --n;
                } else {
                    return target;
                }
            }
        }

        return res;
    }
}
