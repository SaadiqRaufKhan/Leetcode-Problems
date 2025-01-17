class Solution {
    public int findDuplicate(int[] nums) {
        // apply count sort on the array
        // whichever element is not at its correct index is the ans
        int i = 0;
        while(i < nums.length) {
            int correctIdx = nums[i];
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

        // int slow = nums[0];
        // int fast = nums[0];
        // do {
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // } while (slow != fast);

        // fast = nums[0];
        // while (slow != fast) {
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }
        // return slow;
    }
}