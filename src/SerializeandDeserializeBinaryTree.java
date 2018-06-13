import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinshuxiao on 2018/6/12.
 */
public class SerializeandDeserializeBinaryTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * Borrow ideas from structure heap.
     *
     * nums[i] is the parents of nums[2*i] and nums[2*i+1].
     * nums[2*i] is left son of nums[i], while nums[2*i+1] is right son of nums[i].
     *
     * If one of son is missing, we set nums[2*i] or nums[2*i+1] to NULL
     *
     * We turn nums[i] into string, delimited by ','
     *
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        sb.append(root.val);
        sb.append(',');
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur.left != null){
                sb.append(cur.left.val);
                q.offer(cur.left);
            }
            sb.append(',');

            if(cur.right != null){
                sb.append(cur.right.val);
                q.offer(cur.right);
            }
            sb.append(',');

        }

        int len = sb.length();
        while(len > 0 && sb.charAt(len-1) == ',') {
            sb.deleteCharAt(len-1);
            --len;
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;

        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int strIdx = 1;

        while(!q.isEmpty()){
            int len = q.size();
            while(len > 0){
                TreeNode cur = q.poll();

                if(strIdx < strs.length && strs[strIdx].length() > 0){
                    cur.left = new TreeNode(Integer.parseInt(strs[strIdx]));
                    q.offer(cur.left);
                }
                ++strIdx;

                if(strIdx < strs.length && strs[strIdx].length() > 0){
                    cur.right = new TreeNode(Integer.parseInt(strs[strIdx]));
                    q.offer(cur.right);
                }
                ++strIdx;

                --len;
            }
        }

        return root;
    }
}
