/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumGap = function(nums) {
    if(nums.length < 2)
        return 0;
    
    let minVal = nums.reduce((a,b) => a <= b ? a:b);
    let maxVal = nums.reduce((a,b) => a >= b ? a:b);
    
    if(minVal == maxVal)
        return 0;
    
    let buckets = [];
    let averageGap = (maxVal - minVal) / (nums.length - 1);
    let bucketsNum = Math.max(1, Math.floor((maxVal-minVal) / averageGap)+1);
    
    for(let i = 0; i < bucketsNum; ++i){
        buckets.push(new bucket());
    }
    
    for(let num of nums){
        let bucketIdx = Math.floor((num - minVal) / averageGap);
        buckets[bucketIdx].add(num);
    }
    
    let previousMax = minVal;
    let maxGap = 0;
    
    for(let i = 0; i < bucketsNum; ++i){
        if(!buckets[i].used)
            continue;

        maxGap = Math.max(maxGap, buckets[i].minVal - previousMax);
        previousMax = buckets[i].maxVal;
    }
    
    return maxGap;
};

class bucket{
    constructor(){
        this.used = false;
        this.maxVal = -1;
        this.minVal = Number.MAX_VALUE;
    }
    
    add(num){
        if(!this.used)
            this.used = true;
        
        this.maxVal = Math.max(this.maxVal, num);
        this.minVal = Math.min(this.minVal, num);
    }
    
}