class Solution {
    boolean canDistribute(int mid, int[] quantities, int n) {
        int count = 0;
        for(int i=0; i<quantities.length; i++) {
            count += (quantities[i] / mid) + (quantities[i] % mid == 0 ? 0 : 1);
        }
        return count <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
       

        int l = 1;
        int r = -1;
        for(int q: quantities) if(q > r) r = q;

        int ans = -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(canDistribute(mid, quantities, n)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }
}