/**
 * @param {string} color
 * @return {string}
 */
var similarRGB = function(color) {
    let cc = color.split('');
    let AB = cc.slice(1,3);
    let CD = cc.slice(3,5);
    let EF = cc.slice(5,7);
    
    let X, Y, Z;
    if(AB[0] === AB[1])
        X = AB[0];
    else{
        X = minNum(AB);
    }
    
    if(CD[0] === CD[1])
        Y = CD[0];
    else{
        Y = minNum(CD);
    }
        
    if(EF[0] == EF[1])
        Z = EF[0];
    else{
        Z = minNum(EF);
    }
    
    return ['#', X, X, Y, Y, Z,Z].join('');
};

/**
 * 
 * We need to make sure the X increase/decrease as less as possible.
 * 
 * if(X > Y):
 *   Choose from [X, X] (only move Y) and [X-1, X-1] (X decreses by only one)
 * 
 * if(X < Y):
 *   Choose from [X, X] (only move Y) and [X+1, X+1] (X increases by only one)
 * 
 * if(X == Y):
 *   return X
 * 
 */
var minNum = function(XY){
    let a = Number.parseInt(XY[0],16);
    let b = Number.parseInt(XY[1],16);
    
    if(a > b){
            if(dist([a,b], [a,a]) < dist([a,b],[a-1,a-1]))
                return a.toString(16);
            else
                return (a-1).toString(16);
    }
    else{
        if(dist([a,b], [a,a]) < dist([a,b],[a+1,a+1]))
            return a.toString(16);
        else
            return (a+1).toString(16);
    }
}

var dist = function(AB, XY){
    let num1 = AB[0] * 16 + AB[1];
    let num2 = XY[0] * 16 + XY[1];
    return (num1-num2)*(num1-num2);
}