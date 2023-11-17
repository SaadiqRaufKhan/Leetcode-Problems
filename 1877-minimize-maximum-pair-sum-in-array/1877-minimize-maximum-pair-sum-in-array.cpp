class Solution {
public:
    int minPairSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int res = -1;
        for(int i=0; i<n/2; i++) {
            int curr = nums[i] + nums[n-i-1];
            res = max(curr, res);
        }
        return res;
    }
};