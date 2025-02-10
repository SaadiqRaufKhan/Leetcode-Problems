class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int currElem = 0;
        int freq = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == currElem) {
                freq++;
                if(freq <= 1) k++;
            }
            else {
                nums[k] = nums[i];
                currElem = nums[i];
                freq = 1;
                k++;
            }
        }
        return k;
    }
}