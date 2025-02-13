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
    int getsum(List<Integer> num) {
        int factor = 1;
        int sum = 0;
        for(int i=num.size()-1; i>=0; i--) {
            sum += (num.get(i) * factor);
            factor *= 10;
        }
        return sum;
    }
    void helper(TreeNode root, List<List<Integer>> numbers, List<Integer> temp) {
        if(root.left == null && root.right == null) {
            temp.add(root.val);
            numbers.add(temp);
            return;
        }
        temp.add(root.val);
        if(root.left != null) {
            helper(root.left, numbers, new ArrayList<>(temp));
        }
        if(root.right != null) {
            helper(root.right, numbers, new ArrayList<>(temp));
        }
    }
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> numbers = new ArrayList<>();
        helper(root, numbers, new ArrayList<>());

        int ans = 0;
        for(List<Integer> num: numbers) {
            int sum = getsum(num);
            ans += sum;
        }
        return ans;
    }
}