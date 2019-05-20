
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    return generateStr(root1) === generateStr(root2);
};

const generateStr = (root) => {
    if(root === null)
        return "";
    
    if(root.left === null && root.right === null)
        return ""+root.val;
    
    let left = generateStr(root.left);
    let right = generateStr(root.right);
    return left+right;
}