class Solution {
public:
    int reverse(int x) {
        int newx = 0;
        while(x != 0) {
            if(newx > INT_MAX/10 || newx < INT_MIN/10) {
                return 0;
            }
            newx *= 10;
            // newx = (newx * 10) + (x % 10);
            newx += x % 10;
            
            x /= 10;
        }
        return newx;
    }
};