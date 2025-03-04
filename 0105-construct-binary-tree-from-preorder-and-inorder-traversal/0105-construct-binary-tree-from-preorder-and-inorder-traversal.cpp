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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int n = preorder.size();
        if(n == 0) return NULL;
        if(n == 1) return new TreeNode(preorder[0]);

        int rootVal = preorder[0];
        TreeNode* root = new TreeNode(rootVal);
        
        vector<int> leftPreorder;
        vector<int> leftInorder;
        vector<int> rightPreorder;
        vector<int> rightInorder;

        // first fill the inorder subtree vectors (easy to partition because of rootVal)
        int i = 0;
        while(inorder[i] != rootVal) {
            leftInorder.push_back(inorder[i++]);
        }
        i++;
        while(i < n) {
            rightInorder.push_back(inorder[i++]);
        }

        // now fill the preorder subtree vectors (we now know the size of left and right subtrees)
        int j = 1;
        while(j <= leftInorder.size()) {
            leftPreorder.push_back(preorder[j++]);
        }
        while(j < n) {
            rightPreorder.push_back(preorder[j++]);
        }

        TreeNode* leftans = buildTree(leftPreorder, leftInorder);
        TreeNode* rightans = buildTree(rightPreorder, rightInorder);

        root->left = leftans;
        root->right = rightans;
        return root;
    }
};