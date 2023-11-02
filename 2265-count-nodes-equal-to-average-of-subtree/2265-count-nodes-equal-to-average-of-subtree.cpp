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
class Triplet {
public:
    int num;
    int sum;
    int count;
    
    Triplet(int n, int s, int c) {
        num = n;
        sum = s;
        count = c;
    }
};


class Solution {
public:
    // returns <<num,sum>, count>
    Triplet helper(TreeNode* root) {
        if(root == NULL) {
            Triplet t(0,0,0);
            return t;
        }
        
        Triplet lans = helper(root->left);
        Triplet rans = helper(root->right);
        
        int n = lans.num + rans.num + 1;
        int s = lans.sum + rans.sum + root->val;
        int c = lans.count + rans.count; 
        if(s/n == root->val) {
            c++;
        }
        
        Triplet ans(n,s,c);
        return ans;
    }
    int averageOfSubtree(TreeNode* root) {
        Triplet ans = helper(root);
        return ans.count;
    }
};