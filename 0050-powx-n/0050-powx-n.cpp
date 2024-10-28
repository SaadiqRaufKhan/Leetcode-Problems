class Solution {
public:
    // HINT: write the power 'n' in binary and think from there
    double myPow(double x, int n) {
        long long power = n;    // copy n and make it +ve to deal with -ve powers
        if(n < 0) {
            power = -1 * power;
        }
        double ans = 1;
        
        while(power > 0) {
            int last_bit = power & 1;
            if(last_bit) {
                ans *= x;
            }
            x = x * x;          // square the base in each iteration
            power = power>>1;   // right shift to remove the last bit of power
        }
              
        if(n < 0) {
            return (double)1.0 / (double)ans;
        }
        return ans;

    }
};