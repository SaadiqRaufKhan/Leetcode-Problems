class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while(i < n) {
            int correctIdx = nums[i] - 1;
            // if the correctIdx already has the correct value i.e. nums[i], just move ahead
            if(nums[correctIdx] == nums[i]) {
                i++;
            }
            else {  // swap
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int j=0; j<n; j++) {
            if(nums[j] != j+1) {
                res.add(nums[j]);
            }
        }
        return res;
    }
}