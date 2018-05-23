import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/23.
 */
public class FindDuplicateNumber {

    public static void main(String[] args){
        FindDuplicateNumber fdn = new FindDuplicateNumber();

        int[] nums = {1,3,4,2,2};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+fdn.findDuplicate(nums));

        nums = new int[]{2,2,2,2,2};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+fdn.findDuplicate(nums));

        nums = new int[]{1,2,3,3,4};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+fdn.findDuplicate(nums));

    }

    /**
     *
     * This question is interesting.
     * Finding the duplicated number in the array is not difficult.
     * We have lots of solutions: (1) hashmap + iteration; (2) O(n^2) iteration
     * If we know all elements range from 1 to n, we can take full use of index space.
     *
     * But ... but we are asked the array is read-only array, which bring difficulties.
     * Seems like all we can do is to use O(n^2) iteration.
     * But it requires a solution which time complexity is better than O(n^2) ......
     *
     * Alright, better than O(n^2), what about O(nlgn)? we turn to Binary Search ...
     *
     * Well, most people, including me, do binary search on array's index space,
     * I mean, our L and R represented index in the array.
     *
     * But, we're also able to do binary search on values' range space. We can always find Maximum and Minimum in the array.
     * And all elements range from Maximum and Minimum. Our L and R can also represent those value in this space.
     *
     * As described above, we do binary search on values' range space, when we meet a new MID, we count numbers of elements less than or equal to MID in the array.
     * Suppose cnt is that number:
     * if cnt <= MID:
     *     which means in [L, MID], there are not duplicates
     *     E.G. [1,2,3,3,4], MID = 2, cnt = 2, we can see [1,2] did not contain duplicates
     *     L = MID+1
     * if cnt > MID:
     *     which means in [L, MID], there are duplicates
     *     E.G. [1,3,4,2,2], MID = 2, cnt = 3, [1, 2, 2] obviously contains duplicates.
     *     R = MID
     *
     */

    public int findDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int l = min, r = max;
        while(l < r){
            int mid = l + (r-l)/2;

            int cnt = 0;
            for(int num : nums){
                if(num <= mid) ++cnt;
            }

            if(cnt <= mid) l = mid+1;
            else r = mid;
        }

        return l;
    }
}
