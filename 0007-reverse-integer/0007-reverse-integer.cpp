class Solution {
public:
    int reverse(int x) {
        int newx = 0;
        while(x != 0) {
            if(newx > INT_MAX/10 || newx < INT_MIN/10) {
                return 0;
            }
            newx *= 10;
            newx += x % 10;
            x /= 10;
        }
        return newx;
    }
};

    // x = 123
    // newx = 0
    // d = 3
    // newx = 0 + 3 -> 3
    // d = 2
    // newx * 10 -> 3* 10 = 30 -> 30 + 2 = 32
    // d = 1
    // newx * 10 -> 32 * 10 = 320 -> 320+1 = 321 
        
    
    
    
    
    