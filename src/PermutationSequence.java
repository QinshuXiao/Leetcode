class Solution {
    private int[] pers;
    
    public String getPermutation(int n, int k) {
        pers = new int[n+1];
        
        pers[0] = 1;
        for(int i = 1; i <= n; ++i){
            pers[i] = i*pers[i-1];
        }
        
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = i+1;
        
        return getPermutation(nums, k-1);
    }
    
    private String getPermutation(int[] nums, int k){
        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }
        else if(nums.length == 2){
            if(k == 0)
                return String.valueOf(nums[0])+String.valueOf(nums[1]);
            else
                return String.valueOf(nums[1])+String.valueOf(nums[0]);
        }
        
        if(k == 0){
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < nums.length; ++i){
                sb.append(nums[i]);
            }
            return sb.toString();
        }
        
        int firstDigitIdx = k / pers[nums.length-1];
        int[] leftNums = new int[nums.length-1];
        for(int i = 0, j = 0; i < nums.length; ++i){
            if(i == firstDigitIdx)
                continue;
            leftNums[j++] = nums[i];
        }
        
        return String.valueOf(nums[firstDigitIdx]) + 
            getPermutation(leftNums, k % pers[nums.length-1]);
    }
    
}