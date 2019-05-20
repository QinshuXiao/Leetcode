/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    return generateSubsets(nums, 0);
};

var generateSubsets = function(nums, startIdx) {
    if(startIdx == nums.length)
        return [[]];
    let res = [];
    
    let rightSubsets = generateSubsets(nums, startIdx+1);
    for(let subset of rightSubsets){
        res.push(subset);
        res.push([nums[startIdx], ...subset]);
    }
    
    return res;
}