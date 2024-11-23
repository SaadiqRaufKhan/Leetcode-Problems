class Solution {
    public int maxProduct(int[] nums) {
        int max_till_now = nums[0];
        int min_till_now = nums[0];
        int res = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int temp = Math.min(nums[i], Math.min(nums[i]*min_till_now, nums[i]*max_till_now));
            max_till_now = Math.max(nums[i], Math.max(nums[i]*min_till_now, nums[i]*max_till_now));
            min_till_now = temp;
            
            res = Math.max(res, max_till_now);
            
        }
        return res;
    }
}