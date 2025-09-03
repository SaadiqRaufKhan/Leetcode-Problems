class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // the idea is to take a slice out of the circular ring
        // that slice should have the min sum
        int curMaxSum = 0;
        int curMinSum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = 0;
        
        for (int num: nums) {
            // Normal Kadane's
            curMaxSum = Math.max(curMaxSum, 0) + num;
            maxSum = Math.max(maxSum, curMaxSum);
            
            // Kadane's but with min to find minimum subarray
            curMinSum = Math.min(curMinSum, 0) + num;
            minSum = Math.min(minSum, curMinSum);
            
            totalSum += num;  
        }

        if (totalSum == minSum) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}