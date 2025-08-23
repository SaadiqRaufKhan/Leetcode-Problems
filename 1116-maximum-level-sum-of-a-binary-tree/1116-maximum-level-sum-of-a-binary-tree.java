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
    public int maxLevelSum(TreeNode root) {
        int maxsum = Integer.MIN_VALUE;
        int maxlevel = 0;

        Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            int currsum = 0;
            int size = q.size();
            while(size > 0) {
                TreeNode node = q.poll();
                currsum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                size--;
            }
            if(currsum > maxsum) {
                maxsum = currsum;
                maxlevel = level;
            }

            level++;
        }
        return maxlevel;
    }
}