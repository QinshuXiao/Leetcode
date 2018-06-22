import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by qinshuxiao on 2018/6/21.
 */
public class KthLargestElementinanArray {

    public static void main(String[] args){
        KthLargestElementinanArray finder = new KthLargestElementinanArray();

        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Nums: "+ Arrays.toString(nums)+" K: "+k);
        System.out.println("Result: "+finder.findKthLargest(nums, k));
        System.out.println("=====================================");

        nums = new int[] {3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println("Nums: "+ Arrays.toString(nums)+" K: "+k);
        System.out.println("Result: "+finder.findKthLargest(nums, k));
        System.out.println("=====================================");
    }

    public int findKthLargest(int[] nums, int k) {
        //return PQfindKElement(nums, k);
        return quick_select(nums, k);
    }

    /**
     * Priority Queue
     * O(nlgn) + O(k)
     *
     */
    public int PQfindKElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            if(pq.size() == k){
                if(num > pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }
            else pq.offer(num);
        }

        return pq.peek();

    }

    /**
     *
     * Quick Sort way, using partition function from QuickSort
     * Averagely O(n) + O(1)
     *
     */
    public int quick_select(int[] nums, int k) {
        int l = 0, r = nums.length-1;

        while(l < r){
            int mid = partition(nums, l, r);
            if(mid == k-1) return nums[mid];
            else if(mid < k-1) l = mid+1;
            else r = mid-1;

            //System.out.println(Arrays.toString(nums));
        }

        return nums[l];
    }


    private int partition(int[] nums, int l, int r){
        if(l == r) return nums[l];

        int pvt = nums[l], oldR = r;
        swap(nums, l, r);

        while(l < r){
            while(l < r && nums[l] > pvt) ++l;
            while(l < r && nums[r] <= pvt) --r;

            swap(nums, l, r);
        }

        swap(nums, l, oldR);
        return l;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
