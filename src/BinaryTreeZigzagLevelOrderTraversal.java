import java.util.*;

/**
 * Created by qinshuxiao on 2018/6/8.
 */

public class BinaryTreeZigzagLevelOrderTraversal {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        Queue<TreeNode> s = new LinkedList<>();
        s.offer(root);
        boolean needReverse = false;
        List<List<Integer>> res = new ArrayList<>();

        while(!s.isEmpty()){
            List<Integer> rres = new ArrayList<Integer>();

            int len = s.size();
            while(len > 0){
                TreeNode cur = s.poll();
                rres.add(cur.val);
                if(cur.left != null) s.offer(cur.left);
                if(cur.right != null) s.offer(cur.right);
                --len;
            }

            if(needReverse){
                Collections.reverse(rres);
                res.add(rres);
                needReverse = false;
            } else {
                res.add(rres);
                needReverse = true;
            }
        }

        return res;
    }
}
