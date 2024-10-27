class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        
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
        
        
        // while(power > 0) {
        //     if(power % 2 == 0) {   // if bit is 0, ans doesn't change
        //         x = x * x;         // the base gets squared  
        //         power = power / 2;
        //     }
        //     else {              // if bit is 1, ans need to be multiplied
        //         ans = ans * x;
        //         power = power - 1;
        //     }
        // }

        if(n < 0) {
            return (double)1.0 / (double)ans;
        }
        return ans;

    }
};