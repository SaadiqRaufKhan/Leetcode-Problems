class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
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
        for(int j=0; j<n; j++) {
            if(nums[j] != j) return j;
        }
        return n;
    }
}