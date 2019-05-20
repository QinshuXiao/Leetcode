/**
 * @param {number[]} tree
 * @return {number}
 */
var totalFruit = function(tree) {
    let basket1 = 0, basket2 = -1;
    let count = 0, maxLen = 0;
    
    for(let i = 0; i < tree.length; ++i ){
        ++count;
        if( tree[basket1] == tree[i]){
            basket1 = i;
        } else if(basket2 == -1 || tree[basket2] == tree[i]){
            basket2 = i;
        } else {
            maxLen = Math.max(maxLen, count-1);
            count = i - Math.min(basket1,basket2);
            basket1 = i;
            basket2 = i-1;
        }
    }
    
    maxLen = Math.max(maxLen, count);
    
    return maxLen;
};