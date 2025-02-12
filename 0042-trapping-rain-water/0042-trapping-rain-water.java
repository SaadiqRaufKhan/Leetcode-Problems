class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        // fill lmax and rmax
        for(int i=1; i<n; i++) {
            lmax[i] = Math.max(height[i-1], lmax[i-1]);
        }
        for(int i=n-2; i>=0; i--) {
            rmax[i] = Math.max(height[i+1], rmax[i+1]);
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            int min_height = Math.min(lmax[i], rmax[i]);
            if(min_height > height[i]) {
                ans += (min_height - height[i]);
            }
        }
        return ans;
    }
}