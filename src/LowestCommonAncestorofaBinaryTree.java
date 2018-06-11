/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class LowestCommonAncestorofaBinaryTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * Recursion.
     *
     * If we find one node, we return that node.
     *
     * So, we firstly find nodes on the left-subtree and right-subtree.
     *  (1). If we found one node in left-subtree, while another one in right-subtree,
     *      Then we know our root should be the lowest ancestor.
     *  (2). If all nodes in right-subtree, then the lowest ancestor should be in right-subtree.
     *  (3). If all nodes in left-subtree, then the lowest ancestor should be in left-subtree.
     *  (4). Otherwise, return null.
     *
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        /**
         * If root.val equals one of p's or q's value, then we know we find one node.
         */
        if(root.val == p.val || root.val == q.val) return root;

        /**
         * We search nodes on left subtree and right subtree.
         */
        TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFound = lowestCommonAncestor(root.right, p, q);

        /**
         * If we found one node in left-subtree, while another one in right-subtree,
         * Then we know our root should be the lowest ancestor.
         */
        if(leftFound != null && rightFound != null) return root;
        /**
         * If we found all nodes in right-subtree, then the lowest ancestor should be in right-subtree.
         *
         * Or if we found nothing both in left-subtree and right-subtree we return null.
         */
        else if(leftFound == null) return rightFound;
        /**
         * If we found all nodes in left-subtree, then the lowest ancestor should be in left-subtree.
         */
        else return leftFound;
    }
}
