class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int break_point = -1;
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                break_point = i;
                break;
            }
        }
        // no break point found -> array is in descending order
        if(break_point == -1) {
            int i = 0;
            int j = n - 1;
            while(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
        else {
            // find the first element greater than nums[break_point]
            int i = n-1;
            while(i > break_point) {
                if(nums[i] > nums[break_point]) {
                    int temp = nums[i];
                    nums[i] = nums[break_point];
                    nums[break_point] = temp;
                    break;
                }
                i--;
            }
            // reverse the remaining half
            int j = n-1;
            break_point++;
            while(break_point < j) {
                int temp = nums[j];
                nums[j] = nums[break_point];
                nums[break_point] = temp;
                break_point++; j--;
            }
        }
    }
}