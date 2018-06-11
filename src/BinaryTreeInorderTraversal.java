import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/10.
 */
public class BinaryTreeInorderTraversal {

    private class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * Do DFS on Binary Tree.
     * Visit left subtree firstly, then visit root, finally visit right subtree
     *
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res){
        if(root == null) return;

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
