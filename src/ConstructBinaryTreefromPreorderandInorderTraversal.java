import apple.laf.JRSUIUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/5/28.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ConstructBinaryTreefromPreorderandInorderTraversal runner  = new ConstructBinaryTreefromPreorderandInorderTraversal();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        System.out.println("Preorder: "+ Arrays.toString(preorder)+"  Inorder: "+Arrays.toString(inorder));
        TreeNode res = runner.buildTree(preorder, inorder);

    }

    /**
     *
     * preorder can help you to determine which one should be at upper level than others.
     * inorder can help you determine you're in the left or right of the other node.
     *
     * Firstly, we traversal inorder to record the order of a node to a hashmap
     * Secondly, we retrieve first number from preorder, and build a root node for tree.
     * Then, traversal the rest number from preorder, determine the actual position based on built tree and hashmap we built in the 1st step
     *
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        Map<Integer, Integer> orderMap = new HashMap<>();

        for(int i = 0; i < inorder.length; ++i){
            orderMap.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; ++i){
            TreeNode cur = root;
            while(cur != null){
                if(orderMap.get(preorder[i]) < orderMap.get(cur.val)){
                    if(cur.left == null){
                        cur.left = new TreeNode(preorder[i]);
                        cur = null;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if(cur.right == null){
                        cur.right = new TreeNode(preorder[i]);
                        cur = null;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }

        return root;
    }
}
