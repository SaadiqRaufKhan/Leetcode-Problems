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
// same approach as below but it uses a single map and backtracks 
class Solution {
    private int ans = 0;
    private void helper(TreeNode root, int target, long prefixsum, Map<Long, Integer> map) {
        if (root == null) return;

        // update the current path sum
        prefixsum += root.val;

        // check if there is a prefix sum that would lead to the target
        long diff = prefixsum - target;
        ans += map.getOrDefault(diff, 0);

        // update the map
        map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);

        // subtree traversal
        helper(root.left, target, prefixsum, map);
        helper(root.right, target, prefixsum, map);

        // backtrack: remove the current path sum count for other branches
        map.put(prefixsum, map.get(prefixsum) - 1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // base case: one path with sum 0
        helper(root, targetSum, 0L, map);
        return ans;
    }


}


// class Solution {
//     int ans = 0;
//     void helper(TreeNode root, int target, long prefixsum, Map<Long, Integer> map) {
//         prefixsum += root.val;
//         if(map.containsKey(prefixsum - target)) {
//             ans += map.get(prefixsum - target);
//         }
//         map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        
//         if(root.left != null) {
//             helper(root.left, target, prefixsum, new HashMap<>(map));
//         }
//         if(root.right != null) {
//             helper(root.right, target, prefixsum, new HashMap<>(map));
//         }
//     }
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null) return 0;
//         Map<Long, Integer> map = new HashMap<>();
//         map.put(0L, 1);
//         helper(root, targetSum, 0, map);
//         return ans;
//     }
// }