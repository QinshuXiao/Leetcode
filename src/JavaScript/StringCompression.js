/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    if(chars.length === 0){
        return chars.length;
    }
    
    let startIdx = 0, endIdx = 0;
    let writeIdx = 0;
    
    while(endIdx <= chars.length){
        if(chars[startIdx] !== chars[endIdx] || endIdx === chars.length)
        {
            let cnt = (endIdx - startIdx).toString();
            chars[writeIdx++] = chars[startIdx];
            if(parseInt(cnt) > 1){
                for(let ch of [...cnt]){
                    chars[writeIdx++] = ch;
                }
            }
            
            startIdx = endIdx;
        }
        ++endIdx;
    }
    
    chars = chars.slice(0, writeIdx);
    return writeIdx;
};