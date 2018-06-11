/**
 * Created by qinshuxiao on 2018/6/10.
 */
public class InorderSuccessorinBST {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * Recursion.
     * Note that we do recursion along with passing a upperRight node.
     *
     * What do I mean 'upperRight' node?
     * I mean, to the right subtree of left subtree's root of current root, the current root is 'upperRight' node.
     *
     *       root
     *     /
     *   A
     *    \
     *    B
     *
     *  So, to node B, root is B's 'upperRight' node.
     *
     * But why do we pass 'upperRight' node?
     * Because, the next node which is next to B in order is the root.
     *
     */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return search(root, p, null);
    }

    private TreeNode search(TreeNode root, TreeNode p, TreeNode upperRight){
        if(root == null) return null;

        if(root.val == p.val){
            if(root.right == null) return upperRight;
            else{
                TreeNode res = root.right;
                while(res.left != null) res = res.left;
                return res;
            }
        } else if(root.val < p.val){
            return search(root.right, p, upperRight);
        } else {
            return search(root.left, p, root);
        }
    }
}
