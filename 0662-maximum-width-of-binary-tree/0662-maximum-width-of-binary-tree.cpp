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
    int widthOfBinaryTree(TreeNode* root) {
        queue<pair<TreeNode*,int>> q;
        q.push({root,0});
        
        int maxWidth = 0;
        
        // traverse level-wise
        while(!q.empty()) {
            int size = q.size();
            int minIndex = q.front().second; // diiferent for each level
            int leftMost, rightMost;
            // for level wise traversal
            for(int i=0; i<size; i++) {
                TreeNode* front = q.front().first;
                // subtract minIndex from each element's index to avoid overflow
                int currIndex = q.front().second - minIndex; 
                q.pop();
                // 0th element of the queue is the leftmost element
                if(i == 0) {
                    leftMost = currIndex;
                }
                // (n-1)th element of the queue is the rightmost element 
                if(i == size-1) {
                    rightMost = currIndex;
                }
                // if front has a left child push it in the queue
                if(front -> left) {
                    q.push({front -> left, (long long)currIndex * 2 + 1});
                }
                // if front has a right child push it in the queue
                if(front -> right) {
                    q.push({front -> right, (long long)currIndex * 2 + 2});
                }
            }
            // compute maxWidth for the current level
            maxWidth = max(maxWidth, rightMost - leftMost + 1);
        }
        return maxWidth;
    }
};