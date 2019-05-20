var twoSum = function(nums, target) {
    var map = {};
    for(let i = 0; i < nums.length; ++i){
        if(map.hasOwnProperty(target - nums[i]))
            return [ map[target - nums[i]], i];
        
        map[nums[i]] = i;
    }
    
    return [0, 0];
};

console.log(twoSum([1,2,3,4], 6));