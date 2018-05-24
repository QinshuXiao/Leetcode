import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/5/23.
 */
public class MissingRanges {

    public static void main(String[] args){
        MissingRanges mr = new MissingRanges();

        int[] nums = {1,1,3,4,5};
        int lower = 0, upper = 10;
        System.out.println("Input: "+ Arrays.toString(nums)+ " lower:"+lower
                +" upper:"+upper+" Result:"+mr.findMissingRanges(nums, lower, upper).toString());

        nums = new int[]{7};
        lower = 0;
        upper = 9;
        System.out.println("Input: "+ Arrays.toString(nums)+ " lower:"+lower
                +" upper:"+upper+" Result:"+mr.findMissingRanges(nums, lower, upper).toString());

        nums = new int[]{7,8};
        lower = 0;
        upper = 9;
        System.out.println("Input: "+ Arrays.toString(nums)+ " lower:"+lower
                +" upper:"+upper+" Result:"+mr.findMissingRanges(nums, lower, upper).toString());

        nums = new int[]{7,8,9};
        lower = 0;
        upper = 9;
        System.out.println("Input: "+ Arrays.toString(nums)+ " lower:"+lower
                +" upper:"+upper+" Result:"+mr.findMissingRanges(nums, lower, upper).toString());

        nums = new int[]{};
        lower = 0;
        upper = 9;
        System.out.println("Input: "+ Arrays.toString(nums)+ " lower:"+lower
                +" upper:"+upper+" Result:"+mr.findMissingRanges(nums, lower, upper).toString());

        nums = new int[]{2147483647};
        lower = 0;
        upper = 2147483647;
        System.out.println("Input: "+ Arrays.toString(nums)+ " lower:"+lower
                +" upper:"+upper+" Result:"+mr.findMissingRanges(nums, lower, upper).toString());
    }

    /**
     *
     * Actually, this kind of problem, the logic is not hard, the difficulty comes from edge cases
     *
     * the solution is simple, you do a iteration, and update lower number based on the number you meet.
     * That's it!
     *
     * But, you have care about some edge cases:
     * 1. What if the array contains duplicates?
     *      e.g. [1,1,3,4,5]
     *      When you update curLower, you must not use curLower++, instead, you use curLower = nums[i]+1
     * 2. How to deal with upper?
     *      (1): [7] lower:0, upper:9
     *      Well, after iteration, you have curLower = 8, which is lower than 9, you have to add "8->9" into result.
     *
     *      (2): what if [7,8], lower:0, upper:9.
     *      After iteration, lower = 9, which is equal to 9, you also need to add "9" into result.
     *
     *      (3): Now [7,8,9], lower:0, upper:9.
     *      After iteration, lower = 10, which is higher than 9, now you don't need to add anything.
     *
     * 3. As we would possibly increase curLower when we meet the new number, we need to care about overflow problem.
     *      e.g. [2147483647], lower:0, upper:2147483647
     *      we need to declare curLower as a long type of variable.
     *
     *
     *
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        long curLower = lower;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > curLower){
                StringBuilder sb = new StringBuilder();
                sb.append(curLower);
                if(nums[i] > curLower+1){
                    sb.append("->");
                    sb.append(nums[i]-1);
                }
                res.add(sb.toString());
            }
            curLower = (long)nums[i]+1;
        }

        if(curLower <= upper){
            StringBuilder sb = new StringBuilder();
            sb.append(curLower);
            if(upper > curLower){
                sb.append("->");
                sb.append(upper);
            }
            res.add(sb.toString());
        }

        return res;
    }
}
