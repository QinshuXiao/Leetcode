/**
 * The rand7() API is already defined for you.
 * var rand7 = function() {}
 * @return {number} a random integer in the range 1 to 7
 */
var rand10 = function() {
    let row = rand7();
    let col = rand7();
    
    let val = (row-1) * 7 + col;
    while(val > 40){
        row = rand7();
        col = rand7();
        val = (row-1)*7 + col;
    }
    
    return val % 10 + 1;
    
};