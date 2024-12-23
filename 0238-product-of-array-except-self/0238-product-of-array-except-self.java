class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lmul = new int[n];
        int[] rmul = new int[n];
        
        lmul[0] = 1;
        for(int i=1; i<n; i++) {
            lmul[i] = lmul[i-1] * nums[i-1];
        }
        rmul[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            rmul[i] = rmul[i+1] * nums[i+1];
        }
        
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++) {
            ans[i] = lmul[i] * rmul[i];
        }
        return ans;
        
    }
}