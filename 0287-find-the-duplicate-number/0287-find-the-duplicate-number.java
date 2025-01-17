class Solution {
    public int findDuplicate(int[] nums) {
        // apply count sort on the array
        // whichever element is not at its correct index is the ans
        int i = 0;
        while(i < nums.length) {
            int correctIdx = nums[i] - 1;
            // the element at correctIdx should be correctIdx+1
            if(nums[correctIdx] != nums[i]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            }
            else {
                i++;
            }

        }
        for(int j=0; j<nums.length; j++) {
            if(nums[j] != j+1) return nums[j];
        }
        return -1;
    }
}

























/*
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

 */