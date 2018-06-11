/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class ConvertSortedArraytoBinarySearchTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * As we're asked to build a **BALANCE** BST,
     * we have to choose middle element in array to be root of BST, in order to keep **BALANCE**.
     *
     * That's clear, we can recursively build left subtree( nums[l ... mid] ) and right subtree( nums[mid+1 ... r] )
     *
     *
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int len = nums.length;
        return buildTree(nums, 0, len);
    }

    private TreeNode buildTree(int[] nums, int l, int r){
        if(l >= r) return null;

        // choose middle one to be root
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // build left subtree
        root.left = buildTree(nums, l, mid);
        // build right subtree
        root.right = buildTree(nums, mid+1, r);
        return root;
    }
}
