class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if(nums.size() == 2) return (nums[0]-1) * (nums[1]-1);
        
        sort(nums.begin(), nums.end());
        
        int n = nums.size();
        
        return max((nums[0]-1) * (nums[1]-1), (nums[n-2]-1)*(nums[n-1]-1));
    }
};