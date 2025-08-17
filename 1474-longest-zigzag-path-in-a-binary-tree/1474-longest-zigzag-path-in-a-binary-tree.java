/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int helper(TreeNode root, int dir, int len) {
        if(root == null) return len;

        int lans = 0, rans = 0;
        if(dir == -1) { // came rom left
            lans = helper(root.left, -1, 0);
            rans = helper(root.right, 1, len + 1);
        }
        else {
            lans = helper(root.left, -1, len + 1);
            rans = helper(root.right, 1, 0);
        }
        return Math.max(lans, rans);
    }
    public int longestZigZag(TreeNode root) {
        int lans = helper(root.left, -1, 0);
        int rans = helper(root.right, 1, 0);

        return Math.max(lans, rans);
    }
}