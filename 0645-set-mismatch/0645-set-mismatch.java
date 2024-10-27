class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        // boolean[] isDone = new boolean[n];
        
        while(i < n) {
            int correctIdx = nums[i] - 1;
            if(nums[correctIdx] == nums[i]) {
                i++;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }
        
        int[] arr = new int[2];
        
        for(int j=0; j<n; j++) {
            if(nums[j] != j+1) {
                arr[0] = nums[j];
                arr[1] = j+1;
                return arr;
            }
        }
        return arr;
    }
}