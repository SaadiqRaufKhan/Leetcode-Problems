class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[i] == 0 && nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++; j++;
            }
            else if(nums[i] == 0 && nums[j] == 0) {
                j++;
            }
            else {
                i++; j++;
            }
        }
    }
}