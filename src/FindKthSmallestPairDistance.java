import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/6/25.
 */
public class FindKthSmallestPairDistance {

    public static void main(String[] args){
        FindKthSmallestPairDistance finder = new FindKthSmallestPairDistance();

        int[] nums = new int[]{1,3,1};
        int k = 1;

        System.out.println("num: "+Arrays.toString(nums)+" k:"+k);
        System.out.println("Result: "+finder.smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[1] - nums[0];
        for(int i = 1; i < nums.length; ++i){
            min = Math.min(min, nums[i]-nums[i-1]);
        }
        int max = nums[nums.length-1] - nums[0];

        while(min < max){
            int mid = min + (max - min) / 2;

            if(countPair(nums, mid) < k) min = mid+1;
            else max = mid;
        }

        return min;
    }

    private int countPair(int[] nums, int diff){
        int cnt = 0;
        for(int i = 0; i < nums.length; ++i){
            cnt += upperBound(nums, i, nums.length-1, nums[i] + diff) - i - 1;
        }

        return cnt;
    }

    // Returns index of first index of element which is greater than key
    private int upperBound(int[] nums, int low, int high, int key) {
        if (nums[high] <= key) return high + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
