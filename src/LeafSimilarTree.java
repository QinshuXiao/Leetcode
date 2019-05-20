
class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return generateLeafStr(root1).equals(generateLeafStr(root2));
    }
    
    private String generateLeafStr(TreeNode root){
        if(root == null)
            return "";
        
        if(root.left == null && root.right == null)
            return Integer.toString(root.val);
        
        String left = generateLeafStr(root.left); 
        String right = generateLeafStr(root.right);
        return left+right;
    }
}