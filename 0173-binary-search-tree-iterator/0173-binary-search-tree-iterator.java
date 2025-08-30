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
class BSTIterator {
    List<Integer> inorder;
    int idx = -1;
    int size = -1;
    void fillList(TreeNode root, List<Integer> inorder) {
        if(root == null) return;

        fillList(root.left, inorder);
        inorder.add(root.val);
        fillList(root.right, inorder);
    }
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        fillList(root, inorder);
        idx = 0;
        size = inorder.size();
    }
    
    public int next() {
        int val = inorder.get(idx);
        idx++;
        return val;
    }
    
    public boolean hasNext() {
        if(idx >= size) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */