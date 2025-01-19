class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long nn = n;
        if(n < 0) {
            nn = (long)-1 * (long)n;
        }
        while(nn > 0) {
            if((nn & 1) != 0) {
                ans *= x;
            }
            x *= x;
            nn = nn >> 1;
        }

        if(n < 0) {
            return (double)1.0 / (double)ans;
        }
        return ans;
    }
}