class Solution {
public:
    void helper(vector<int> nums, int pos, vector<vector<int>>& ans, vector<int> vec) {
        // we don't need base condition because the for loop will handle it
        
        // at the first call level is 0, so we push empty vec we into ans
        // for later calls we'll fill it and pass on further
        ans.push_back(vec);

        // run a for-loop to make unique calls and at each recursive call, level will automatically increase and so will be the size vec
        for(int i=pos; i<nums.size(); i++) {
            // to include the element at ith index we use these conditions
            if(i == pos || nums[i] != nums[i-1]) {
                vec.push_back(nums[i]);
                helper(nums, i+1, ans, vec);
                vec.pop_back();
            }
        }

    
        
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> vec;
        helper(nums, 0, ans, vec);
        return ans;
    }
};