/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class SymmetricTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    /**
     *
     * Recursion.
     *
     * For a tree, root.
     * If it's a symmetric tree, its left subtree and its right subtree has to be mirror of each other.
     *
     * What is mirror?
     * isMirror(left.right, right.left) && isMirror(left.left, right.right) && left.val == right.val
     *
     * The same logic for all nodes.
     *
     *       3              4
     *     /   \           / \
     *    2    2          3  3
     *     \   /         /   \
     *     1  1         2    2
     *
     */

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return isMirror(left.right, right.left) && isMirror(left.left, right.right) && left.val == right.val;
    }
}
