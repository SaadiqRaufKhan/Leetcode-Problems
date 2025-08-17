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
    void getSequence(TreeNode root, List<Integer> seq) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }
        getSequence(root.left, seq);
        getSequence(root.right, seq);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        getSequence(root1, l1);
        getSequence(root2, l2);

        return l1.equals(l2);
    }
}