/**
 * Created by qinshuxiao on 2018/6/10.
 */
public class ValidateBinarySearchTree {

    private class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * From bottom to top.  Firstly check left subtree, then check right subtree, finally check root.
     *
     *           upperRight
     *       /
     *  upperLeft
     *         \
     *         B
     *
     * To B, B'value should be larger than upperLeft's value and be less than upperRight's value.
     *
     * check(root, upperLeft, upperRight):
     *      if root == null:
     *          return true
     *
     *      if(!check(root.left, upperLeft, root)) return false;
     *      if(!check(root.right, root, upperRight)) return false;
     *
     *      return (upperLeft == null || upperLeft.val < root.val)
     *              && (upperRight == null || upperRight.val > root.val);
     *
     */

    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, TreeNode upperLeft, TreeNode upperRight){
        if(root == null) return true;

        if(!check(root.left, upperLeft, root)) return false;
        if(!check(root.right, root,upperRight)) return false;

        return (upperLeft == null || upperLeft.val < root.val) && (upperRight == null || upperRight.val > root.val);
    }
}
