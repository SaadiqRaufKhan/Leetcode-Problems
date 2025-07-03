class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> leftProduct(nums.size(), 1);
        vector<int> rightProduct(nums.size(), 1);

        for(int i=1; i<nums.size(); i++) {
            leftProduct[i] = nums[i-1] * leftProduct[i-1];
        }

        for(int i=nums.size()-2; i>=0; i--) {
            rightProduct[i] = nums[i+1] * rightProduct[i+1];
        }

        vector<int> ans;
        for(int i=0; i<nums.size(); i++) {
            ans.push_back(leftProduct[i] * rightProduct[i]);
        }
        return ans;
    }
};

















//         int n = nums.size();
//         vector<int> answer(n, 1);
//         for(int i=n-2; i>=0; i--) {
//             answer[i] = answer[i+1] * nums[i+1];
//         }

//         int L = 1;
//         for(int i=0; i<n; i++) {
//             answer[i] = answer[i] * L;
//             L = L * nums[i];
//         }

//         return answer;