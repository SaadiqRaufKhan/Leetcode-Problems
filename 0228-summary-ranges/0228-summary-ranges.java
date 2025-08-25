class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(nums[0]));
        int len = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1] + 1) {
                if(len > 1) sb.append("->" + String.valueOf(nums[i-1]));
                ans.add(sb.toString());
                sb.setLength(0);
                sb.append(String.valueOf(nums[i]));
                len = 1;
            }
            else len++;
        }
        if(len > 1) sb.append("->" + String.valueOf(nums[n-1]));
        ans.add(sb.toString());
        return ans;
    }
}