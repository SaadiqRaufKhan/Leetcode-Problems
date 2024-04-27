// class Solution {                      
// public:
//     int reverse(int x) {
//         int r=0;      // decleare r 
//         while(x){
//          if (r>INT_MAX/10 || r<INT_MIN/10) return 0; // check 32 bit range if r is outside the range then return 0 
//          r=r*10+x%10; // find remainder and add its to r
//          x=x/10;     // Update the value of x
//         } 
//         return r;  // if r in the 32 bit range then return r
//     }
// };

class Solution {
public:
    int reverse(int x) {
        int newx = 0;
        while(x != 0) {
            if(newx > INT_MAX/10 || newx < INT_MIN/10) {
                return 0;
            }
            
            newx = (newx * 10) + (x % 10);
            x /= 10;
        }
        return newx;
    }
};