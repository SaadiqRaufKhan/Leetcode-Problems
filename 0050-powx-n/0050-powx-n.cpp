class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        long long power = n;
        if(n < 0) {
            power = -1 * power;
        }
        double ans = 1;
        while(power > 0) {
            if(power % 2 == 0) {   // if bit is 0, ans doesn't change
                x = x * x;        // the base gets squared  
                power = power / 2;
            }
            else {              // if bit is 1, ans need to be multiplied
                ans = ans * x;
                power = power - 1;
            }
        }

        if(n < 0) {
            return (double)1.0 / (double)ans;
        }
        return ans;

    }
};