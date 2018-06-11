/**
 * Created by qinshuxiao on 2018/6/11.
 */
public class BinaryTreeMaximumPathSum {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *
     * DP on tree.
     * Recursive function returns local maximum of path sum which passed through root.
     * Then we passed a global variable in recursive function, where we possibly update global maximum.
     *
     */

    public int maxPathSum(TreeNode root) {
        long[] max = new long [1];
        max[0] = Integer.MIN_VALUE;

        findMax(root, max);
        return (int)max[0];
    }

    /**
     *
     * @param root : tree's root
     * @param max : store global maximum path sum of tree
     * @return : Local path maximum which path passed through root, either its self value, or its left path sum, or its right path sum,
     *           which is max(self, max(self + left, self + right))
     */
    private long findMax(TreeNode root, long[] max){
        if(root == null) return 0;

        /**
         * Do computation on left subtree and right subtree
         */
        long self = root.val, left = findMax(root.left, max), right = findMax(root.right, max);

        /**
         * Possibly update global maximum
         */
        if(self + right + left > max[0]) max[0] = self+right+left;
        if(self + right > max[0]) max[0] = self+right;
        if(self + left > max[0]) max[0] = self+left;
        if(self > max[0]) max[0] = self;

        /**
         * Return local path maximum
         */
        return Math.max(self, Math.max(self+left, self+right));
    }
}
