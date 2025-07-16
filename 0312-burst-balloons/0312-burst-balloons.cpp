// Recursive approach
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();

        // base cases - return only when 1 balloon is remaining
        if(n == 1) return nums[0];

        int ans = 0;
        // i will iterate over each of the coin
        for(int i=0; i<n; i++) {
            int left = (i == 0) ? 1 : nums[i-1];
            int right = (i == n-1) ? 1 : nums[i+1];
            int coins = left * nums[i] * right;
            
            vector<int> nums2;
            for(int j=0; j<n; j++) {
                if(j != i) nums2.push_back(nums[j]);    // skip the ith coin
            }
            ans = max(ans, coins + maxCoins(nums2));
        }
        return ans;
    }
};
