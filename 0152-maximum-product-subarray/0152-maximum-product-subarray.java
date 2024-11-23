class Solution {
    public int maxProduct(int[] nums) {
        int[] max_till_now = nums.clone();
        int[] min_till_now = nums.clone();
        int[] res = nums.clone();
        
        for(int i=1; i<nums.length; i++) {
            min_till_now[i] = Math.min(nums[i], Math.min(nums[i]*min_till_now[i-1], nums[i]*max_till_now[i-1]));
            max_till_now[i] = Math.max(nums[i], Math.max(nums[i]*min_till_now[i-1], nums[i]*max_till_now[i-1]));
            
            res[i] = Math.max(res[i-1], max_till_now[i]);
            
        }
        return res[nums.length - 1];
    }
}