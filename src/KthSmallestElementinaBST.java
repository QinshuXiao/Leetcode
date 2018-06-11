/**
 * Created by qinshuxiao on 2018/6/10.
 */
public class KthSmallestElementinaBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * Do Binary Search on BST.
     * It's just like do DFS on BST, so that we can visit nodes in order.
     * And we record how many nodes we have visited, and once we visited Kth node, we return it.
     *
     * search(TreeNode root, int k, TreeNode res):
     *      if root == null:
     *          return 0
     *
     *      left := search(root.left, k, res)
     *      if left + 1 == k:
     *          res.val = root.val
     *          return k
     *      elif left >= k :
     *          return k
     *      else:
     *          right := search(root.right, k-left-1, res)
     *          if left+1+right >= k:
     *              return k
     *          else:
     *              return left+1+right
     *
     *
     */

    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = new TreeNode(0);

        search(root, k, res);
        return res.val;
    }

    private int search(TreeNode root, int k, TreeNode res){
        if(root == null) return 0;

        int left = search(root.left, k, res);
        if(left == k-1){
            res.val = root.val;
            //System.out.println("Find! node:"+res.val);
            return k;
        } else if(left >= k){
            return k;
        } else {
            int right = search(root.right, k-left-1, res);
            if(right +left + 1 >= k) return k;
            else return right+left+1;
        }
    }
}
