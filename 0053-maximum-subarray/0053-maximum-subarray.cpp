class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSum = INT_MIN;
        int currSum = 0;
        
        for(int i=0; i<nums.size(); i++) {
            // update currSum
            currSum += nums[i];
            
            // if currSum becomes greater than maxSum, then update it
            maxSum = max(currSum, maxSum);
            
            // if the currSum becomes -ve at some point, drop it & start a fresh currSumm with a value of 0
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }
    
};