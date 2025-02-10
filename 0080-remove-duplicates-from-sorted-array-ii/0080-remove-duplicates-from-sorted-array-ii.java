class Solution {
    public int removeDuplicates(int[] nums) {
        int currFreq = 0;
        int currElem = nums[0];
        int k = 0;      // this acts as the correct index 
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == currElem) {
                currFreq++;
                if(currFreq <= 2) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            else {
                nums[k] = nums[i];
                currElem = nums[i];
                currFreq = 1;
                k++;
            }
        }
        return k;
    }
}