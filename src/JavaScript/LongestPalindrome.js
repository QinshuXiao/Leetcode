/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let sc = s.split('');
    let res = [0,0];
    
    let idx = 0;
    while(idx < sc.length){
        let right = idx;
        while(right < sc.length && sc[right] == sc[idx])
            ++right;
        
        let left = idx - 1;
        idx = right;
        while(left >= 0 && right < sc.length && sc[left] == sc[right]){
            --left;
            ++right;
        }
        left++;
        right--;
        
        if(right - left > res[1] - res[0]){
            res = [left, right];
        }
    }
    
    return sc.slice(res[0], res[1]+1).join('');
};