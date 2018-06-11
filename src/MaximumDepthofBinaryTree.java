import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class MaximumDepthofBinaryTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * BFS using Queue
     *
     */

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()){
            int len = q.size();
            while(len > 0){
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                --len;
            }

            ++depth;
        }

        return depth;
    }
}
