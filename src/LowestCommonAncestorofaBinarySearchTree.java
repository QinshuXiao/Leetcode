/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * Recursion + Property of BST
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }

}
