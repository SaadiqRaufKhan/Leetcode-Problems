class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; 
        int currFreq = 0;
        int currElem = nums[0];
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == currElem) {
                currFreq++;
                if(currFreq <= 2) {
                    nums[k] = nums[i];
                    k++;
                    i++;
                }
                else {
                    i++;
                }
            }
            else {
                nums[k] = nums[i];
                currElem = nums[i];
                currFreq = 1;
                k++;
                i++;
            }
        }
        return k;
    }
}