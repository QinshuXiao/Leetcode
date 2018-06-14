import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/14.
 */
public class CountofSmallerNumbersAfterSelf {

    public static void main(String[] args){
        CountofSmallerNumbersAfterSelf counter = new CountofSmallerNumbersAfterSelf();

        int[] nums = new int[]{5,2,4,1};
        System.out.println("Nums: "+Arrays.toString(nums)+" Result: "+counter.countSmaller(nums));

        nums = new int[]{5,2,6,1};
        System.out.println("Nums: "+Arrays.toString(nums)+" Result: "+counter.countSmaller(nums));
    }

    /**
     *
     * We can get some helps from Merge Sort.
     * Recall merge sort, in the merge stage,
     * when we put an element in the left array to the sorted array,
     * we can know how many elements in the right array larger than that element.
     *
     */

    private class node {
        public int idx, val, cnt;

        public node(int idx, int val) {
            this.idx = idx;
            this.val = val;
            this.cnt = 0;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        node[] arr = new node[nums.length];
        for(int i = 0; i < nums.length; ++i){
            arr[i] = new node(i, nums[i]);
        }

        sort(arr, 0, nums.length-1);

        Integer[] res = new Integer[nums.length];
        for(node n : arr){
            res[n.idx] = n.cnt;
        }

        return Arrays.asList(res);
    }

    private void sort(node[] arr, int l, int r){
        if( l >= r) return;

        int mid = (l+r) / 2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);

        int i = l, j = mid+1, rightCnt = 0, idx = 0;
        node[] sortedArr = new node[r-l+1];
        while(i <= mid && j <= r){
            if(arr[i].val <= arr[j].val){
                arr[i].cnt += rightCnt;
                sortedArr[idx++] = arr[i++];
            } else {
                ++rightCnt;
                sortedArr[idx++] = arr[j++];
            }
        }

        while(j <= r) sortedArr[idx++] = arr[j++];
        while(i <= mid){
            arr[i].cnt += rightCnt;
            sortedArr[idx++] = arr[i++];
        }

        for(i = l; i <= r; ++i){
            arr[i] = sortedArr[i-l];
        }
    }
}
