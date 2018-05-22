import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args){
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println("Input: " + Arrays.toString(nums) + " Result: "+lcs.longestConsecutive(nums));

        nums = new int[]{1,2,0,1};
        System.out.println("Input: " + Arrays.toString(nums) + " Result: "+lcs.longestConsecutive(nums));
    }

    /**
     * Classical solution for finding out consecutive length of unsorted array.
     *
     * Using hashmap to record current consecutive length we can find for element K.
     *
     * Suppose we meet element x, left = map[x-1], right = map[x+1]
     * map[x] = left+right+1
     * map[x-left] = left+right+1
     * map[x-right] = left+right+1
     *
     * Later two equation ensure that the start point and end point of consecutive subarray can keep an up-to-date consecutive length
     *
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        int res = 0;
        for(int num : nums){
            if(m.containsKey(num)) continue;

            int left = 0, right = 0;
            if(m.containsKey(num-1)) left = m.get(num-1);
            if(m.containsKey(num+1)) right = m.get(num+1);

            m.put(num, left+right+1);
            m.put(num-left, left+right+1);
            m.put(num+right, left+right+1);

            res = Math.max(res, left+right+1);
        }

        return res;
    }
}
