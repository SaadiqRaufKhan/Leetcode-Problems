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
    int ans = 0;
    void helper(TreeNode* root, int target, long long prefixsum, unordered_map<long long,int> map) {
        prefixsum += root->val;
        if(map.find(prefixsum - target) != map.end()) {
            ans += map[prefixsum - target];
        }
        map[prefixsum]++;
        if(root->left) {
            helper(root->left, target, prefixsum, map);
        }
        if(root->right) {
            helper(root->right, target, prefixsum, map);
        }
    }
    int pathSum(TreeNode* root, int targetSum) {
        if(!root) return 0;
        unordered_map<long long,int> map;
        map[0l] = 1;
        helper(root, targetSum, 0l, map);
        return ans;
    }
};