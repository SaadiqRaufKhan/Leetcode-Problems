class Solution {
public:
    // bool subsetSum(vector<int>& nums, int pos, int targetSum) {
    //     if(targetSum == 0) {
    //         return true;
    //     }
    //     if(pos == nums.size()) {
    //         return false;
    //     }

    //     // include curr elem
    //     bool res1 = false;
    //     if(nums[pos] <= targetSum) {
    //         res1 = subsetSum(nums, pos+1, targetSum-nums[pos]);
    //     }

    //     // exclude curr elem
    //     bool res2 = subsetSum(nums, pos+1, targetSum);
        
    //     // return their OR (because any one path returning true will suffice)
    //     return (res1 || res2);
    // }

    bool subsetSum(vector<int>& nums, int targetSum) {
        // initialize a 2D dp matrix with false
        vector<vector<int>> dp(nums.size(), vector<int>(targetSum+1, false));

        // base case: 1. targetSum = 0 -> all true in 0th column
        for(int i=0; i<nums.size(); i++) {
            dp[i][0] = true;
        }
        // 2. if arr[0] <= targetSum (within bouds) -> true in that particular cell dp[0][arr[0]] because we can make a sum of arr[0] using that particular element
        if(nums[0] <= targetSum) {
            dp[0][nums[0]] = true;
        }

        // fill remaining dp matrix
        for(int i=1; i<nums.size(); i++) {
            for(int sum=1; sum<=targetSum; sum++) {
                // curr elem not taken
                bool notTaken = dp[i-1][sum];
                // curr elem taken
                bool taken = false; 
                if(nums[i] < sum) {
                    taken = dp[i-1][sum-nums[i]];
                }
                dp[i][sum] = taken || notTaken;
            }
        }

        return dp[nums.size()-1][targetSum];

    }
    // main function
    bool canPartition(vector<int>& nums) {
        int totalSum = 0;
        for(auto num: nums) {
            totalSum += num;
        }
        // if the total totalSum is ODD, we can never divide it equally
        if(totalSum % 2 != 0) {
            return false;
        }

        // problem reduces to targetSum with it being equal to:
        int targetSum = totalSum / 2;

        return subsetSum(nums, targetSum);
    }
};