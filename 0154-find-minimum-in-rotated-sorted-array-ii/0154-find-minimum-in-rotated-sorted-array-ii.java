class Solution {
    int ans = Integer.MAX_VALUE;
    void bs(int[] nums, int s, int e, int n) {
        if(s > e) return;

        int mid = s + (e - s) / 2;
        ans = Math.min(ans, nums[mid]);

        // clearly on the right
        if(nums[mid] < nums[n-1] || nums[mid] < nums[0]) { 
            bs(nums, s, mid - 1, n);
        }
        // clearly on the left line
        else if(nums[mid] > nums[0] || nums[mid] > nums[n-1]) {
            bs(nums, mid + 1, e, n);
        }
        // not sure
        else {
            bs(nums, s, mid - 1, n);
            bs(nums, mid + 1, e, n);
        }
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n-1]) return nums[0];
        bs(nums, 0, n-1, n);
        return ans;
    }
}