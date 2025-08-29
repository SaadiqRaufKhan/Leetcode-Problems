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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0) return null;
        int rootVal = postorder[n-1];
        TreeNode root = new TreeNode(rootVal);

        if(n == 1) return root;

        int rootIdx = -1;
        for(int i=0; i<n; i++) {
            if(inorder[i] == rootVal) {
                rootIdx = i; 
                // System.out.println("root idx = " + rootIdx);
                break;
            }
        }

        int leftsize = rootIdx;
        int rightsize = n - rootIdx - 1;

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIdx+1, n);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftsize);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftsize, n-1);

        TreeNode left = buildTree(leftInorder, leftPostorder);
        TreeNode right = buildTree(rightInorder, rightPostorder);

        root.left = left;
        root.right = right;
        return root;
    }
}