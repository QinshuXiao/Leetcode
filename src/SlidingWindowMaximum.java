class Solution {
    
    /*
     First solution: 
     using PriorityQueue to store the elements within the window.
     The top one is the maximum within the window.
     Small tip: 
     store the element with its index. By doing that, we can easily clean the PQ when we move the window forward.
     */
    public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        if(nums.length == 0)
            return nums;

        /*
         * Using PriorityQueue to store the elements,
         * The top one is the largest elements within the window.
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> {
            return b[1] - a[1];
        } );
        
        for(int i = 0; i < k; ++i){
            pq.offer(new int[]{i, nums[i]});
        }
        
        int[] res = new int[nums.length-k+1];
        int idx = 0;
        while(idx <= nums.length-k){
            int[] top = pq.peek();
            res[idx] = top[1];
            
            // move forward the window;
            ++idx;
            
            /*
             * Clean the priorityQueue
             * Make sure pop the elements which has smaller idx than current idx we are standing at.
             * O(logk) to adjust
             */
            while(!pq.isEmpty() && pq.peek()[0] < idx){
                pq.poll();
            }
            
            /*
             * add the new touched elements.
             */ 
            if(idx + k - 1 < nums.length){
                pq.offer(new int[]{idx+k-1, nums[idx+k-1]});
            }
        }
        
        return res;
    }

    /*
     * Second solution: Using Deque to store the elements within the window.
     * We are trying to find a O(n) solution.
     * After analyzing the problem deeper, I found out that 
     * we don't actually need store every elements within the window.
     * Because the elements which are smaller than the new coming element will never be the maximum.
     * So, there are no needs to keep the order of every elements. We can give up priorityqueue.
     * So, instead of priorityqueue, we use ArrayDeque which gives us o(1) insertion and deletion
     * keeping the maximum in the first of deque.
     * Each time when we move forward the window, we will clean the elements which are smaller than
     * the new coming elements and out-of-window elements, then put the new coming elements in the
     * end of the deque.
     */


    // using deque to store elements (actually the idx of element) within the window.
    // Keeping the maximum as the first elements.
    private ArrayDeque<Integer> deque;
    private int[] nums;
    
    /*
     * cleanDeque:
     * When we move forward the window, we will call clean deque.
     * Because we need to remove the elements which are out of window,
     * And we need to remove the elements which are smaller than the new coming elements.
     */    
    private void cleanDeque(int idx, int k){
        
        // If the previous maximum is out of window, then remove it
        // So that's the reason why we store idx instead of elements.
        while(!deque.isEmpty() && deque.getFirst() <= idx-k)
            deque.removeFirst();
        
        // Remove the elements which are smaller than the new coming element.
        // As those elements will never be the maximum, keeping them is meaningless.
        while(!deque.isEmpty() && nums[idx] >= nums[deque.getLast()]){
            deque.removeLast();
        }
        
        /* 
         * After performing cleanDeque, we will ensure the elements in deque
         * will be sorted descendingly by values but ascendingly by idx.
         */
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 1)
            return nums;
        
        deque = new ArrayDeque<>();
        this.nums = nums;
        
        // initialize the deque and put first k elements inside it.
        // the first window.
        for(int i = 0; i < k; ++i){
            cleanDeque(i, k);
            deque.addLast(i);
        }
        
        int[] res = new int[nums.length - k+1];
        res[0] = nums[deque.getFirst()];
        
        for(int i = k; i < nums.length; ++i){
            
            /*
             * each time we move forward the window,
             * we clean the deque firstly, then added the new coming elements in the end of the deque.
             * By doing that, we will ensure the elements in deque
             * will be sorted descendingly by values but ascendingly by idx.
             */
            cleanDeque(i, k);
            deque.addLast(i);
            res[i-k+1] = nums[deque.getFirst()];
        }
        
        return res;
    }
}