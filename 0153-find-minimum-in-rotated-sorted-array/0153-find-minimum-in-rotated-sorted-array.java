class Solution {
    public int findMin(int[] nums) {
        // check which line do we land on
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        while(s <= e) {
            int mid = s + (e - s)/2;
            // landed on left line -> move right
            if(nums[mid] > nums[n-1]) s = mid + 1;

            // landed on right line -> move left
            else e = mid - 1;
        }
        
        return nums[s];
    }
}