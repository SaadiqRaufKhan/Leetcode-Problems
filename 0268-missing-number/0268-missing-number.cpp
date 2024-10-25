class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int i = 0;
        // cycle sort
        while(i < n) {
            if(nums[i] == i || nums[i] == n) {  // ignore case
                i++;
            }
            else {  // swap case
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        
        // linear search to find the first incorrect element
        for(int i=0; i<n; i++) {
            if(nums[i] != i) return i;
        }
        return n;
    }
};