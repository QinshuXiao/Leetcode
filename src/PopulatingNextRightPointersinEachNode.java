import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class PopulatingNextRightPointersinEachNode {

    private class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }

    /**
     *
     * Iterative way:
     *
     * Do BFS, and every time we meet a new node,
     * we point its next pointer to node on its right side, which is the front node in queue
     *
     */

    public void iterativeConnect(TreeLinkNode root) {
        if(root == null) return;

        Queue<TreeLinkNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();

            while(len > 0){
                TreeLinkNode cur = q.poll();
                --len;
                if(len > 0){
                    cur.next = q.peek();
                } else {
                    cur.next = null;
                }

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }

        return;
    }


    /**
     *
     * Recursion way:
     *
     * 1. connect Left Subtree
     * 2. connect right subtree
     * 3. connect right boundary of left subtree with left boundary of right subtree.
     *
     */

    public void recursiveConnect(TreeLinkNode root){
        if(root == null) return;

        /**
         * 1. connect Left Subtree
         * 2. connect right subtree
         */
        recursiveConnect(root.left);
        recursiveConnect(root.right);

        /**
         * 3. connect right boundary of left subtree with left boundary of right subtree.
         */
        TreeLinkNode left = root.left, right = root.right;
        while(left != null && right != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}
