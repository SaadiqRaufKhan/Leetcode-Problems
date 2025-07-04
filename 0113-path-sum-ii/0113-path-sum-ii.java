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
    void helper(TreeNode root, int target, List<List<Integer>> ans, List<Integer> path) {
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                path.add(root.val);
                ans.add(path);
            }
            return;
        }
        path.add(root.val);
        if(root.left != null) {
            helper(root.left, target-root.val, ans, new ArrayList<>(path));
        }
        if(root.right != null) {
            helper(root.right, target-root.val, ans, new ArrayList<>(path));
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, ans, new ArrayList<>());
        return ans;
    }
}