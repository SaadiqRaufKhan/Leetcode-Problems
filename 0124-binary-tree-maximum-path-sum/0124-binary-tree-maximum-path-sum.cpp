/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int helper(TreeNode* root, int &ans) {
        if(root == NULL) {
            return 0;
        }
        // get answers from left and right
        // max with 0 is for filtering out -ve sums
        int leftAns = max(0, helper(root->left, ans));
        int rightAns = max(0, helper(root->right, ans));

        // update ans before returning a path
        ans = max(ans, leftAns + rightAns + root->val);

        // return the path (either left or right) which gives
        // the maximum sum 
        return root->val + max(leftAns, rightAns);

    }
    int maxPathSum(TreeNode* root) {
        int ans = -1e9; // ans will store the max path sum
        helper(root, ans);
        return ans;
    }
};