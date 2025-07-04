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
    void helper(TreeNode* root, int target, int *ans, long long prefixsum, unordered_map<long long,int> map) {
        prefixsum += root->val;
        if(map.find(prefixsum - target) != map.end()) {
            (*ans) += map[prefixsum - target];
        }
        map[prefixsum]++;
        if(root->left) {
            helper(root->left, target, ans, prefixsum, map);
        }
        if(root->right) {
            helper(root->right, target, ans, prefixsum, map);
        }
    }
    int pathSum(TreeNode* root, int targetSum) {
        if(!root) return 0;
        unordered_map<long long,int> map;
        map[0l] = 1;
        int ans = 0;
        helper(root, targetSum, &ans, 0l, map);
        return ans;
    }
};


//  void helper(TreeNode root, int target, long prefixsum, int[] ans, Map<Long, Integer> map) {
//         prefixsum += root.val;
//         if(map.containsKey(prefixsum - target)) {
//             ans[0] += map.get(prefixsum - target);
//             // System.out.println(map);
//         }
//         map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        
//         if(root.left != null) {
//             helper(root.left, target, prefixsum, ans, new HashMap<>(map));
//         }
//         if(root.right != null) {
//             helper(root.right, target, prefixsum, ans, new HashMap<>(map));
//         }
//     }
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null) return 0;
//         int[] ans = {0};
//         Map<Long, Integer> map = new HashMap<>();
//         map.put(0L, 1);
//         helper(root, targetSum, 0, ans, map);
//         return ans[0];
//     }