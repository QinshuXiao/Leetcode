import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qinshuxiao on 2018/6/10.
 */
public class BinaryTreeLevelOrderTraversal {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * Using Queue to do BFS
     *
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){
            List<Integer> subres = new ArrayList<>();

            int len = q.size();
            while(len > 0){
                TreeNode cur = q.poll();
                subres.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                --len;
            }

            res.add(subres);
        }

        return res;
    }
}
