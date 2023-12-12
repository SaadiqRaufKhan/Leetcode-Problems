class Solution {
public:
    int maxProduct(vector<int>& nums) {        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        // return the max of product of first-two and last-two elements
        return max((nums[0]-1) * (nums[1]-1), (nums[n-2]-1)*(nums[n-1]-1));
    }
};