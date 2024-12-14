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
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] arr = {Integer.MIN_VALUE};
        helper(root, arr);
        
        return arr[0];
    }
    
    int helper(TreeNode root, int[] arr) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            arr[0] = Math.max(root.val, arr[0]);
            return root.val;
        }
        int lans = helper(root.left, arr);
        int rans = helper(root.right, arr);
        
        int lsum = root.val + lans;
        int rsum = root.val + rans;
        int tsum = lans + rans + root.val;
        
        int temp = Math.max(tsum, Math.max(root.val, Math.max(lsum, rsum)));
        arr[0] = Math.max(arr[0], temp);
        return Math.max(root.val, Math.max(lsum, rsum));
        
        
    }
}