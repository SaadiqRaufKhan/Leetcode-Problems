class Solution {
    // same approach as cycle sort
    // ignore -ve and >n elements, sort the rest
    // then check from the starting position of the array for 1 to n
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while(i < n) {
            int correctIdx = nums[i] - 1;
            if(nums[i] <= 0 || nums[i] > n || nums[correctIdx] == nums[i]) {
                i++;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }
        
        for(int j=0; j<n; j++) {
            if(nums[j] != j+1) return j+1;
        }
        
        // if we are here this means that array has all elements from 1 to n
        // return nums[n-1] + 1;
        return n+1;
    }
}