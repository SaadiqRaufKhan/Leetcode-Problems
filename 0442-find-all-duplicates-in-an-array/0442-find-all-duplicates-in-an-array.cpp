class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        int i = 0;
        int n = nums.size();
        
        while(i < n) {
            // get the correct index for nums[i]
            int correctIdx = nums[i] - 1;
            if(nums[correctIdx] == nums[i]) {
                i++;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }
        
        vector<int> res;
        for(int j=0; j<n; j++) {
            if(nums[j] != j+1) {
                res.push_back(nums[j]);
            }
        }
        return res;
        
    }
};