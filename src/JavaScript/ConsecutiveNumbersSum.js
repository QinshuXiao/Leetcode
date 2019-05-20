const consecutiveNumbersSum = function(N) {
    let res = 0;
    for(let k = 1; ;k++){
        let kx = N - k * (k-1) / 2;
        if(kx <= 0)
            break;
        if(kx % k === 0)
            ++res;
    }
    
    return res;
};