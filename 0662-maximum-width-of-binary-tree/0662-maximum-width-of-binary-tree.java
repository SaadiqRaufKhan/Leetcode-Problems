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

class Pair<T, V> {
    T first;
    V second;
    Pair(T t, V v) {
        first = t;
        second = v;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        int maxWidht = 0;
        while(!q.isEmpty()) {
            // the size tells us how many nodes are at the current level
            int size = q.size();

            // to store the leftMost and rightMost index for the current level
            int leftMost = 0;
            int rightMost = 0;

            // traverse over the current level's nodes
            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.first;
                int currIndex = p.second;
                // set leftMost and rightMost (they will corresponding to the first and last nodes in the queue)
                if(i == 0) {
                    leftMost = currIndex;
                }
                if(i == size-1) {
                    rightMost = currIndex;
                }

                // push currNode's child nodes in the queue
                if(node.left != null) {
                    q.add(new Pair<>(node.left, currIndex*2));
                }
                if(node.right != null) {
                    q.add(new Pair<>(node.right, currIndex*2 + 1));
                }
            }
            maxWidht = Math.max(maxWidht, rightMost - leftMost + 1);
        }
        return maxWidht;

    }
}