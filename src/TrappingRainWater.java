class Solution {
    /*
     * The key point is to find the next bar j which is higher that the current bar i.
     * And the trapped water from i to j is sum(height[i]-height[w]) where i < w < j
     *
     * But we need to note that i could be both the left of j and the right of j.
     * So we need to do 2 ways iteration:
     *     the first round is from left to right
     *     the second round is from right to left 
     */
    public int trap(int[] height) {
        int[] water = new int[height.length];
        int left = 0, right = 0;
        
        // first iteration : iterate from left to right
        while(left<height.length-1 && height[left] <= height[left+1])
            ++left;
        
        right = left+1;
        while(right < height.length){
            while(right < height.length && height[right] < height[left]){
                ++right;
            }
            
            if(right == height.length)
                break;
            
            int hi = height[left];
            while(left < right){
                water[left] = hi - height[left];
                ++left;
            }
            
            while(left < height.length-1 && 
                 height[left] <= height[left+1])
                ++left;
            
            right = left + 1;
        }
        
        // second iteration : from right to left
        right = height.length-1;
        while(right > 0 && height[right] <= height[right-1])
            --right;
        
        left = right-1;
        while(left >= 0){
            while(left >= 0 && height[left] < height[right])
                --left;
            
            if(left < 0)
                break;
            
            int hi = height[right];
            while(right > left){
                water[right] = hi-height[right];
                --right;
            }
            
            while(right > 0 && height[right] <= height[right-1])
                --right;
        
            left = right-1;
        }
        
        int res = 0;
        for(int i = 0; i < water.length; ++i)
            res += water[i];
        
        return res;
    }
}