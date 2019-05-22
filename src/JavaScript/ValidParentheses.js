/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = [];
    
    let sc = s.split("");
    for(let c of sc)
    {
       if(c === '(' || c === '{' || c === '['){
           stack.push(c);
       }
       else if(c === ']'){
           if(stack.length === 0 || stack[stack.length-1] != '[')
               return false;
           stack.pop();
       }
       else if(c === ')'){
           if(stack.length === 0 || stack[stack.length-1] != '(')
               return false;
           stack.pop();
       }
       else if(c === '}'){
           if(stack.length === 0 || stack[stack.length-1] != '{')
               return false;
           stack.pop();
       }
    }
    
    return stack.length === 0;
};