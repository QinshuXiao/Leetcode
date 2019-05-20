/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var subarraysWithKDistinct = function(A, K) {
    let window1 = new window();
    let window2 = new window();
    let left1 = 0, left2 = 0, right = 0, res = 0;
    
    while(right < A.length){
        let num = A[right++];
        window1.add(num);
        window2.add(num);
        
        while(window1.size() > K){
            window1.remove(A[left1++]);
        }
        while(window2.size() >= K){
            window2.remove(A[left2++]);
        }
        
        res += left2 - left1;
    }
    
    return res;
};

class window{
    constructor(){
        this.window = {};
        this.count = 0;
    }
    
    add(num){
        if(this.window.hasOwnProperty(num)){
            this.window[num]++;
        }
        else{
            this.window[num] = 1;
        }
        
        if(this.window[num] === 1){
            this.count++;
        }
    }
    
    remove(num){
        this.window[num]--;
        if(this.window[num] === 0)
            this.count--;
    }
    
    size(){
        return this.count;
    }
}

console.log(subarraysWithKDistinct([1,2,1,2,3],2));