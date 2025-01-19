class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums); // nlog(n)
        List<Integer> ans = new ArrayList<>();
        
        int n = nums.length;
        int target = (int) Math.floor(n/3);
        int i = 0;
        
        while(i < n) {
            int count = 0;
            int elem = nums[i];
            while(i < n && nums[i] == elem) {
                count++;
                i++;
            }
            if(count > target) {
                ans.add(elem);
            }
        }
        return ans;
    }
}