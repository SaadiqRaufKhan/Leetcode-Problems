class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while(i < n) {
            int correctIdx = nums[i] - 1;   // nums[i]'s correct idx
            if(nums[correctIdx] != nums[i]) {   // swap 
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else {
                i++;
            }
        }
        
        for(int j=0; j<n; j++) {
            if(nums[j] != j+1) return nums[j];
        }
        return -1;
    }
}