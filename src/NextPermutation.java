class Solution {
    public void nextPermutation(int[] nums) {
        // find the last peak idx
        // because we cannot make an descending array bigger.
        // we need to find the most significant digit we can still change.
        int peakIdx = nums.length - 1;
        while(peakIdx > 0 && nums[peakIdx] <= nums[peakIdx-1])
            --peakIdx;
        
        // if it is a descending array, we cannot find a bigger one.
        // just reverse the array.
        if(peakIdx == 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        // the next element need to be swapped is the left element of the last peak
        // this idx is the most significant digit which can give us a bigger result once changed.
        int left = peakIdx - 1;
        
        // find the first element which is larger than nums[left];
        int right = nums.length-1;
        while(right > left && nums[right] <= nums[left])
            --right;
        
        // then swap nums[left] and nums[right]
        swap(nums, left, right);
        
        // Because we need to find the next bigger array, 
        // we need to reverse the array from peakIdx to the end
        // as nums[peakIdx ... end] is an descending array, we need to make it ascendingly.
        // for example, original [1,2,4,3] -first swap-> [1,3,4,2] -reveser peak to the end-> [1,3,2,4]
        reverse(nums, left+1, nums.length-1);
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    void reverse(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l, r);
            ++l;
            --r;
        }
    }
}