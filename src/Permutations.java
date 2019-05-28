class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Integer[] workingArr = new Integer[nums.length];
        for(int i = 0; i < nums.length; ++i){
            workingArr[i] = nums[i];
        }
        permute(workingArr, 0, res);
        return res;
    }
    
    // backtracking, enumerate every possibilities at each index.
    private void permute(Integer[] nums, int idx, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<Integer>(Arrays.asList(nums)));
            return ;
        }
        
        for(int j = idx; j < nums.length; ++j){
            nums = swap(nums, idx, j);   
            permute(nums, idx + 1, res);
            nums = swap(nums, idx, j);
        }
    }
    
    Integer[] swap(Integer[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return nums;
    }
}