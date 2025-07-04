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
    void helper(TreeNode root, int target, long prefixsum, int[] ans, Map<Long, Integer> map) {
        prefixsum += root.val;
        if(map.containsKey(prefixsum - target)) {
            ans[0] += map.get(prefixsum - target);
            // System.out.println(map);
        }
        map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        
        if(root.left != null) {
            helper(root.left, target, prefixsum, ans, new HashMap<>(map));
        }
        if(root.right != null) {
            helper(root.right, target, prefixsum, ans, new HashMap<>(map));
        }
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int[] ans = {0};
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(root, targetSum, 0, ans, map);
        return ans[0];
    }
}