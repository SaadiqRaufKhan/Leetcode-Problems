class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        double sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i]; 
            if(i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i-k+1];
            }
        }
        return maxSum/k;
    }
}

